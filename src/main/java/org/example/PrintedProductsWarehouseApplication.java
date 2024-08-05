package org.example;

import org.example.controller.DispatcherController;
import org.example.controller.PrintedItemController;
import org.example.controller.impls.BannerController;
import org.example.controller.impls.BusinessCardController;
import org.example.controller.impls.EducationMaterialController;
import org.example.controller.impls.PackageController;
import org.example.entities.impls.Banner;
import org.example.entities.impls.BusinessCard;
import org.example.entities.impls.EducationalMaterial;
import org.example.entities.impls.Package;
import org.example.exception.CustomException;
import org.example.exception.GlobalExceptionHandler;
import org.example.exception.MisMatchInputException;
import org.example.exception.WrongInputException;
import org.example.view.PrintedItemView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class PrintedProductsWarehouseApplication {

    private static final Scanner scanner = new Scanner(System.in);

    private static final DispatcherController dispatcherController;

    static {
        Map<Class<?>, PrintedItemController<?>> controllers = new HashMap<>();
        controllers.put(Banner.class, new BannerController());
        controllers.put(BusinessCard.class, new BusinessCardController());
        controllers.put(EducationalMaterial.class, new EducationMaterialController());
        controllers.put(Package.class, new PackageController());
        dispatcherController = DispatcherController.getInstance(controllers);
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());
        PrintedItemView.mainMenu();

        try {
            int choice = nextInt("main");
            switch (choice) {
                case 1 -> search();
                case 2 -> list();
                case 0 -> {
                    PrintedItemView.exitMessage();
                    return;
                }
                default -> PrintedItemView.wrongInputMessage();
            }
        } catch (CustomException e) {
            execute(e);
        }
        main(args);
    }


    private static void list() {
        List<String> controllerTypes = dispatcherController.getControllerTypes();
        PrintedItemView.printOptions(controllerTypes);
        int choice = nextInt("list") - 1;
        if (choice == controllerTypes.size()) {
            main(new String[]{});
            return;
        }
        PrintedItemController<?> controller = dispatcherController.getController(choice, "list");
        Collection<?> all = controller.findAll(null);
        PrintedItemView.printResult(all);
    }

    private static void search() {
        List<String> controllerTypes = dispatcherController.getControllerTypes();
        PrintedItemView.printOptions(controllerTypes);
        int choice = nextInt("list") - 1;
        if (choice == controllerTypes.size()) {
            main(new String[]{});
            return;
        }
        PrintedItemController<?> controller = dispatcherController.getController(choice, "search");
        List<String> serviceParameterList = controller.getServiceParameterList();
        PrintedItemView.printOptionsAndHelpText(serviceParameterList);
        Map<String, String> map = criteriaValuesReader(serviceParameterList);

        PrintedItemView.printResult(controller.getData(map));
    }

    private static Map<String, String> criteriaValuesReader(List<String> serviceParameterList) {
        scanner.nextLine();
        String next = scanner.nextLine();
        String[] inputs = next.split(",");
        Map<String, String> map = new HashMap<>();
        for (String input : inputs) {
            int index = parseInt(input);
            String parameterName = serviceParameterList.get(index);
            PrintedItemView.enterValueOfParameterMessage(parameterName);
            String value = scanner.nextLine();
            map.put(parameterName, value);
        }
        return map;
    }

    private static void execute(CustomException e) {
        PrintedItemView.printError(e.getMessage());
        scanner.nextLine();
        try {
            if (e.getaClass() == null) {
                Method method = PrintedProductsWarehouseApplication.class.getDeclaredMethod(e.getMethodNAme());
                method.invoke(null);
            } else {
                Method method = PrintedProductsWarehouseApplication.class.getDeclaredMethod(e.getMethodNAme(), e.getaClass());
                method.invoke(null, e.getArgs());
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int nextInt(String methodName) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new MisMatchInputException(methodName, String[].class, (Object) new String[]{});
        }
    }

    public static int parseInt(String index) {
        try {
            return Integer.parseInt(index.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new WrongInputException("search");
        }
    }

}
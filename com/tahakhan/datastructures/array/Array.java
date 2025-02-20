package com.tahakhan.datastructures.array;

import java.util.Arrays;

public class Array {
    public static void checkDefaultValueForPrimitiveTypes() {
        int[] primitiveIntArray = new int[5];
        float[] primitiveFloatArray = new float[5];
        String c = "value";

        System.out.println("Default value for primitive");
        System.out.println("int = " + primitiveIntArray[0]);
        System.out.println("float = " + primitiveFloatArray[0]);
        System.out.println("char = " + c.charAt(0));
    }

    public static void checkDefaultValueForObjectTypes() {
        String[] stringArray = new String[5];
        Integer[] integerArray = new Integer[5];

        System.out.println();
        System.out.println("Default value for object");
        System.out.println("String = " + stringArray[0]);
        System.out.println("Integer = " + integerArray[0]);
    }

    public static void checkDeepCopyForPrimitiveInt() {
        int[] original = {1, 2, 3, 4, 5};
        int[] shallowCopy = original.clone();

        shallowCopy[0] = 99;

        System.out.println("Deep copy check for primitive int");
        System.out.println("Original: " + java.util.Arrays.toString(original));
        System.out.println("Shallow Copy: " + java.util.Arrays.toString(shallowCopy));
    }

    public static void checkShallowCopyForImmutableObjectInt() {
        Integer[] original = {1, 2, 3, 4, 5};
        Integer[] shallowCopy = original.clone();

        shallowCopy[0] = 99;

        System.out.println("Shallow copy check for object Integer");
        System.out.println("Original: " + java.util.Arrays.toString(original));
        System.out.println("Shallow Copy: " + java.util.Arrays.toString(shallowCopy));
        System.out.println("Since Integer[] stores immutable Integer objects, changing shallowCopy[0] doesn't modify the original array");
    }

    public static void checkShallowCopyForMutablePersonObject() {
        class Person {
            String name;

            Person(String name) {
                this.name = name;
            }

            void setName(String newName) {
                this.name = newName;
            }

        }

        Person[] original = { new Person("Alice") };
        Person[] shallowCopy = original.clone();

        System.out.println("Shallow copy check for object Person");
        System.out.println("Original");
        System.out.println("value: " + original[0].name + " reference: " + original[0]);
        System.out.println("Shallow");
        System.out.println("value: " + shallowCopy[0].name + " reference: " + shallowCopy[0]);

        shallowCopy[0].setName("Alexi");

        System.out.println("After updating 0th index for shallowCopy");
        System.out.println("Original");
        System.out.println("value: " + original[0].name + " reference: " + original[0]);
        System.out.println("Shallow");
        System.out.println("value: " + shallowCopy[0].name + " reference: " + shallowCopy[0]);
    }


    public static void main(String[] args){
        checkDefaultValueForPrimitiveTypes();
        checkDefaultValueForObjectTypes();
        System.out.println();
        checkDeepCopyForPrimitiveInt();
        System.out.println();
        checkShallowCopyForImmutableObjectInt();
        System.out.println();
        checkShallowCopyForMutablePersonObject();
        System.out.println();

        int[][] arr = {{1, 2}, {3, 4}};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr));
    }
}

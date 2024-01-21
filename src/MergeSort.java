class MergeSort {
    public static void mergeSort(int[] mas){
        int n = mas.length;
        if(n==1)return;
        int left = mas.length/2;
        int right = mas.length - left;
        int[] leftMas = new int[left];
        int[] rightMas = new int[right];
        for (int i = 0; i < left; i++) {
            leftMas[i] = mas[i];
        }
        for (int i = 0; i <right ; i++) {
           rightMas[i] = mas[i+left];
        }
        mergeSort(leftMas);
        mergeSort(rightMas);
        merge(mas,leftMas,rightMas);

    }

    public static void merge(int[] mas, int[] leftMas, int[] rightMas){
        int indexLeft = 0;
        int indexRight = 0;
        int index = 0;
        while (indexLeft<leftMas.length && indexRight<rightMas.length) {
            if (leftMas[indexLeft] < rightMas[indexRight]) {
                mas[index++] = leftMas[indexLeft++];
            } else {
                mas[index++] = rightMas[indexRight++];
            }
        }
            for (int i = indexLeft; i <leftMas.length ; i++) {
                mas[index++] = leftMas[i];
            }
            for (int i = indexRight; i <rightMas.length ; i++) {
                mas[index++] = rightMas[i];
            }
        }
    }


import java.util.ArrayList;
/*Функция принимает два отсортированных от меньшего к большему ArrayList одинакового размера [a1, a2, ..., an], [b1, b2, ..., bn].
В результате выполнения функции в первом(!) ArrayList (в данном случае это А) должны содержаться элементы обоих ArrayList,
также отсортированные от меньшего к большему. Второй ArrayList должен остаться неизменненным.
Пример:
Входные данные
A [1,3,5] A[1,3,7,8]
B [2,6,8] B[2,5,6] A[1,3,7,8,2,5,6]
Результат
A [1,2,3,5,6,8]
B [2,6,8]
A [1,3,5,null,null,null] || A[1,3,5,2,6,8]
*/
public class Main {

    static void merge1(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0, j = 0;
        ArrayList<Integer> arrayList = new ArrayList<>(a.size() + b.size());
        for(; i < a.size() && j < b.size();) {
            arrayList.add(a.get(i) < b.get(j) ? a.get(i++) : b.get(j++));
        }
        if (i != a.size())
            for(; i < a.size();) {
                arrayList.add(a.get(i++));
            }
        if (j != b.size())
            for(; j < b.size();) {
                arrayList.add(b.get(j++));
            }
        a.ensureCapacity(a.size() + b.size());
        a.clear();
        a.addAll(arrayList);

        System.out.println(a);
        System.out.println(b);
    }
    static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int k = a.size();
        a.ensureCapacity(a.size() + b.size());
        for(int i = 0; i< b.size(); i++)
            a.add(b.get(i));
        for(int i = 0; i < a.size() - 1; i++)
        {
            if (k == i && k < a.size()) k++;
            if (a.get(i) > a.get(k)) {
                int temp = a.get(i);
                a.set(i, a.get(k));
                a.set(k, temp);
                if (a.get(i+1) < a.get(k)) k++;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(3);
        a.add(1); a.add(3); a.add(5); a.add(7);
        ArrayList<Integer> b = new ArrayList<Integer>(3);
        b.add(2); b.add(6); b.add(8); b.add(9);

        merge(a, b);
        merge1(a,b);
    }
}

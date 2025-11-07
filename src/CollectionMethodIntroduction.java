import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class CollectionMethodIntroduction {
    public static void main(String[] args) {
        ArrayList<Student> originalStudentsList = new ArrayList<>();
        ArrayList<Student> studentsList1 = new ArrayList<>();
        Student a = new Student(20250101, "A", 20, true);
        Student b = new Student(20250102, "B", 22, false);
        Student c = new Student(20250103, "C", 21, true);

        System.out.println(a);
        System.out.println(b);

        originalStudentsList.add(a);
        originalStudentsList.add(b);
        originalStudentsList.add(c);

        originalStudentsList.forEach((student) -> {studentsList1.add(student);});

        ArrayList<Student> studentsList2 = new ArrayList<>();
        studentsList2.add(c);
        System.out.println();

        System.out.println("-------- List --------");

        System.out.println();
        System.out.println("studentsList: " + studentsList1);
        System.out.println();

        System.out.println("코드: studentsList1.forEach((student) -> {System.out.println(student);});\n.forEach(): 모든 요소에 대해 함수 실행 ↓");
        studentsList1.forEach((student) -> {System.out.println(student);});
        System.out.println();
        System.out.println("코드: studentsList1.hashCode()\n.hashCode(): 고유한 정수값을 반환\n→ " + studentsList1.hashCode());
        System.out.println();
        System.out.println("코드: studentsList1.iterator().next()\n.iterator(): 반복자(iterator) 객체 생성\n.next(): 반복자가 가르키는 다음 요소를 반환\n→ " + studentsList1.iterator().next());
        System.out.println();
        System.out.println("코드: studentsList1.stream().anyMatch(student -> student.equals(c))\n.stream(): 스트림으로 변환(stream)\n.anyMatch(): 조건을 만족하는 요소가 하나라도 있는지 검사\n→ " + studentsList1.stream().anyMatch(student -> student.equals(c)));
        System.out.println();
        System.out.println("코드: studentsList1.retainAll(studentsList2)\n.retainAll(): 리스트 자체를 수정.\n괄호 속 컬랙션과의 교집합 빼고 삭제.\n만약 변경이 있으면 true 반환\n→ " + studentsList1.retainAll(studentsList2));
        System.out.println();

        System.out.println("-------- Set --------");

        HashSet<Student> studentsSet = new HashSet<>();
        originalStudentsList.forEach((student) -> studentsSet.add(student));

        System.out.println();
        System.out.println("studentsSet: " + studentsSet);
        System.out.println();

        System.out.println("코드: studentsSet.contains(a)\n.contains(): 괄호 속 요소가 포함돼있는지 확인\n→ " + studentsSet.contains(a));
        System.out.println();
        System.out.println("코드: studentsSet.stream().findAny()\n.stream(): 스트림(Stream)으로 변환\n.findAny(): 아무 요소나 하나를 반환\n→ " + studentsSet.stream().findAny());
        System.out.println();
        System.out.println("코드: studentsSet.stream().anyMatch(student -> student.equals(a))\n.anyMatch(): 조건을 만족하는 요소가 하나라도 있는지 검사\n→ " + studentsSet.stream().anyMatch(student -> student.equals(a)));
        System.out.println();
        System.out.println("코드: studentsSet.retainAll(studentsSet2)\n.retainAll(): 리스트 자체를 수정.\n괄호 속 컬랙션과의 교집합 빼고 삭제.\n만약 변경이 있으면 true 반환\n→ " + studentsSet.retainAll(studentsSet));
        System.out.println();
        System.out.println("코드: studentsSet.forEach((student) -> {System.out.println(student);});\n.forEach(): 모든 요소에 대해 함수 실행 ↓");
        studentsSet.forEach((student) -> {System.out.println(student);});
        System.out.println();

        System.out.println("-------- Map --------");

        HashMap<String, String> studentsMap = new HashMap<>();

        studentsMap.put("no", Integer.toString(a.no));
        studentsMap.put("name", a.name);
        studentsMap.put("age", Integer.toString(a.age));
        studentsMap.put("isMale", Boolean.toString(a.isMale));

        System.out.println();
        System.out.println("studentsMap: " + studentsMap);
        System.out.println();

        System.out.println("코드: studentsMap.keySet()\n.keySet(): 키만 모아 Set으로 반환\n→ " + studentsMap.keySet());
        System.out.println();
        System.out.println("코드: studentsMap.values()\n.values(): 값만 모아 컬렉션으로 반환\n→ " + studentsMap.values());
        System.out.println();
        System.out.println("코드: studentsMap.compute(\"name\", (key, value) -> value + \"님\")\n.compute(): 값을 수정하고 저장\n→ " + studentsMap.compute("name", (key, value) -> value + "님"));
        System.out.println();
        System.out.println("코드: studentsMap.containsValue(\"A\")\n.containsValue(): 값 중에 일치하는 것이 하나라도 있으면 true 반한\n→ " + studentsMap.containsValue("A"));
        System.out.println();
        System.out.println("코드: studentsMap.getOrDefault(\"no\", Integer.toString(a.no))\n.getOrDefault(): 값을 안전하게 조회\n→ " + studentsMap.getOrDefault("no", Integer.toString(a.no)));
    }
}

class Student {
    int no;
    String name;
    int age;
    boolean isMale;

    public Student(int no, String name, int age, boolean isMale) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public String toString() {
        return "no: " + no + ", name: " + name + ", age: " + age + ", isMale: " + isMale;
    }
}
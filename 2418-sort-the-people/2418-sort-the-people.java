class Solution {
    class Person implements Comparable<Person> {
        String name;
        int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(o.height, this.height);
        }
    }

    Person[] people;

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        people = new Person[n];

        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        Arrays.sort(people);

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = people[i].name;
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    static class File implements Comparable<File> {
        String name;
        String head;
        int number;
        
        public File (String name, String head, int number) {
            this.name = name;
            this.head = head;
            this.number = number;
        }
        
        @Override
        public int compareTo(File o) {
            if((this.head).equals(o.head)) {
                return Integer.compare(this.number, o.number);
            } else {
                return (this.head).compareTo(o.head);
            }
        }
    }
    
    static File[] Files;
    
    static String[] splitFileName(String file) {
        String[] str = new String[3];
        str[0] = "";
        str[1] = "";
        str[2] = "";
        
        for(int i = 0, idx = 0; i < file.length() && idx < 3; i++) {
            char c = file.charAt(i);
            if(idx == 0 && !Character.isDigit(c)) { // HEAD, 숫자가 아님
                str[idx] += c; // HEAD에 추가
                continue;
            }
            
            if(idx == 0 && Character.isDigit(c)) { // HEAD, 숫자
                idx++; // NUMBER로 이동
            }
            
            if(idx == 1 && Character.isDigit(c)) { // NUMBER, 숫자
                str[idx] += c; // NUMBER에 숫자 추가
                continue;
            }
            
            if(idx == 1 && !Character.isDigit(c)) { // NUMBER, 숫자 아님
                idx++; // TAIL로 이동
            }
            str[idx] += c;
        }
        
        str[0] = str[0].toLowerCase(); // 대소문자 구분 하지 않음
        
        return str;
    }
    
    public String[] solution(String[] files) {
        Files = new File[files.length];
        
        for(int i = 0; i < files.length; i++) {
            String[] split = splitFileName(files[i]);
            Files[i] = new File(files[i], split[0], Integer.parseInt(split[1]));
        }
        
        Arrays.sort(Files);
        
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            answer[i] = Files[i].name;
        }
        
        return answer;
    }
}
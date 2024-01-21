//Stack для задачи на правильную скобочную последовательность
class Stack {
    private int putloc, getloc;
    private Character[] array;

    Stack(String str) {
        array = new Character[str.length()];
        putloc = getloc = 0;
    }

    public boolean put(char ch) {
        if (putloc != 0) {
            if (ch == ')') {
                if (array[putloc-1]=='('){
                    array[putloc-1]=null;
                    putloc--;
                    return true;
                }else return false;
            }else if(ch == '}'){
                if (array[putloc-1]=='{'){
                    array[putloc-1]=null;
                    putloc--;
                    return true;
                }else return false;
            }else if(ch == ']'){
                if (array[putloc-1]=='['){
                    array[putloc-1]=null;
                    putloc--;
                    return true;
                }else return false;
            }else if(ch == '(' || ch == '{' || ch == '['){
                array[putloc++]=ch;
                return true;
            }else return false;
        }else{
            array[putloc++] = ch;
            return true;
        }
    }
    public boolean check(){
        for(int i = 0; i<array.length;i++){
            if(array[i]!=null){
                return false;
            }
        }
        return true;
    }
}

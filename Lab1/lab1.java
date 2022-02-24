class Lab1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        String[] languages=new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n*=3;
        n+=Integer.parseInt("10101",2);
        n+=Integer.parseInt("FF", 16);
        n*=6;
        System.out.println(n);
        int aux=0;
        aux=digitsum(n);
        while(aux>9){
            aux=digitsum(aux);
        }
        System.out.println(aux);
        System.out.println("Willy-nilly, this semester I will learn " + languages[aux]);
    }
    public static int digitsum(int x){ 
        int nr=x;
        int s=0;
        while(nr!=0){
            s+=nr%10;
            nr=nr/10;
        }
        return s;
    }
}
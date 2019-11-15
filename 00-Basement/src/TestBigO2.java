
public class TestBigO2 {
    public static void main(String[] args) {
        double base =2;
        for(int i=50;i<=600;i=i+1) {
            long n = Math.round(Math.pow(base, i));
            long startTime = System.nanoTime();
            Tools.pow(base,(int)n);
            long endTime = System.nanoTime();
            System.out.println(base+"^"+i+"="+n+"计算需耗时约\t"+(endTime-startTime)/1000000.0+"ms.");
        }

    }
}

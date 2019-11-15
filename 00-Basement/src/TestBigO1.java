public class TestBigO1 {
    public static void main(String[] args) {
        int base = 2;
        for(int i=1;i<=4;i=i+1) {
            long n = Math.round(Math.pow(base, i));
            long startTime = System.nanoTime();
            int x = GoSteps.countWays((int)n);
            long endTime = System.nanoTime();
            System.out.println(base+"^"+i+"="+n+"步共有"+x+"种走法，\t计算耗时约\t"+(endTime-startTime)/1000000.0+"ms.");
        }

    }
}

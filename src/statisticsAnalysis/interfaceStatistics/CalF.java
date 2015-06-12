package statisticsAnalysis.interfaceStatistics;

public class CalF {
	double gammln(double xx)
	{
	        int j;
	        double x, y, tmp, ser;
	        double[] cof = {76.18009172947146,-86.50532032941677,24.01409824083091,-1.231739572450155,
	            0.1208650973866179e-2,-0.5395239384953e-5};
	        y = x = xx;
	        tmp = x + 5.5;
	        tmp -= (x + 0.5) * Math.log(tmp);
	        ser = 1.000000000190015;
	        for (j = 0; j < 6; j++) ser += cof[j] / ++y;
	        return -tmp + Math.log(2.5066282746310005 * ser / x);
	}
	double betacf(double a, double b, double x)
	{
	        int MAXIT = 1000;
	        double EPS = 1e-10;
	        double FPMIN = 1e-8;
	        double m, m2;
	        double aa, c, d, del, h, qab, qam, qap;

	        qab = a + b;
	        qap = a + 1;
	        qam = a - 1;
	        c = 1;
	        d = 1 - qab * x / qap;
	        if (Math.abs(d) < FPMIN) d = FPMIN;
	        d = 1 / d;
	        h = d;
	        for (m = 1; m <= MAXIT; m++)
	        {
	            m2 = 2 * m;
	            aa = m * (b - m) * x / ((qam + m2) * (a + m2));
	            d = 1 + aa * d;
	            if (Math.abs(d) < FPMIN) d = FPMIN;
	            c = 1 + aa / c;
	            if (Math.abs(c) < FPMIN) c = FPMIN;
	            d = 1 / d;
	            h *= d * c;
	            aa = -(a + m) * (qab + m) * x / ((a + m2) * (qap + m2));
	            d = 1 + aa * d;
	            if (Math.abs(d) < FPMIN) d = FPMIN;
	            c = 1 + aa / c;
	            if (Math.abs(c) < FPMIN) c = FPMIN;
	            d = 1 / d;
	            del = d * c;
	            h *= del;
	            if (Math.abs(del - 1) <= EPS) break;
	        }
	        if (m > MAXIT) System.out.println( "a or b too big, or MAXIT too small in betacf");
	        return h;
	}
	double betai(double a, double b, double x)
	{
	        double bt;
	        if (x < 0 || x > 1) System.out.println( "Bad x in routine batai");
	        if (x == 0 || x == 1) bt = 0;
	        else
	            bt = Math.exp(gammln(a + b) - gammln(a) - gammln(b) + a * Math.log(x) + b * Math.log(1 - x));
	        if (x < (a + 1) / (a + b + 2))
	            return bt * betacf(a, b, x) / a;
	        else
	            return 1 - bt * betacf(b, a, 1 - x) / b;
	}
	double fdist(double x, int free1,int  free2)
	{
	        int m, n;
	        if (x <= 0) return 0;
	        if (free1 <= 0 || free2 <= 0) System.out.println( "freedegree must >0");
	        m = free1;
	        n = free2;
	        double p;
	        p = 1 - betai(n / 2, m / 2, n / (n + m * x));
	        return p;
	}
	double fdistinv(double p, int free1, int free2)
	{
	        if (free1 < 1 || free2 < 1) System.out.println( "free must >0 in fdistinv!");
	        if (p < 0 || p > 1) System.out.println( "p must be probability in fdistinv!");
	        if (p == 0) return 0;
	        double xup;
	        int n1, n2;
	        n1 = free1;
	        n2 = free2;
	        double e, dev;
	        if (n2 <= 4)
	        {
	            xup = 500000;
	        }
	        else
	        {
	            e = n2 / (n2 - 2);
	            dev = 2 * n2 * n2 * (n1 + n2 - 2) / (n1 * (n2 - 2) * (n2 - 2) * (n2 - 4));
	            dev = Math.sqrt(dev);
	            xup = e + 20 * dev;
	        }
	        double x2;
	        x2 = xup;
	        if (p > 1 - 1e-8) return x2;
	        int x1 = 0;
	        double xacc = 1e-12;
	        int JMAX = 400;
	        int j;
	        double dx, f, fmid, xmid, rtb;
	        f = fdist(x1, free1, free2) - p;
	        fmid = fdist(x2, free1, free2) - p;
	        if (f * fmid >= 0) System.out.println( "faild in fdist2inv");
	        if (f < 0)
	        {
	            dx = x2 - x1;
	            rtb = x1;
	        }
	        else
	        {
	            dx = x1 - x2;
	            rtb = x2;
	        }
	        for (j = 0; j < JMAX; j++)
	        {
	            dx *= 0.5;
	            xmid = rtb + dx;
	            fmid = fdist(xmid, free1, free2) - p;
	            if (fmid <= 0) rtb = xmid;
	            if (Math.abs(dx) < xacc || fmid == 0) return rtb;
	        }
	        return 0;
	}

	
	public static void main(String[] args){
		CalF c = new CalF();
		System.out.println(c.fdistinv(0.05, 65, 65));
		System.out.println(c.fdistinv(0.95, 65, 65));

	}
}

package ir.mtegco.design_system.Typefaces;

import android.content.Context;
import android.graphics.Typeface;

public class TypefaceHandler {
    public final static int BTitrBold = 1;
    public final static int BYekan = 2;
    public final static int BTraffic = 3;
    public final static int BTrafficBold = 4;
    public final static int BZarBold = 5;

    public static Typeface getTypeface(Context context, int enumTypeface) {
        switch (enumTypeface) {
            case BTitrBold:
                return new BTitrBold(context).getTypeface();
            case BYekan:
                return new BYekan(context).getTypeface();
            case BTraffic:
                return new BTraffic(context).getTypeface();
            case BTrafficBold:
                return new BTrafficBold(context).getTypeface();
            case BZarBold:
                return new BZarBold(context).getTypeface();
        }
        return new BYekan(context).getTypeface();
    }
}

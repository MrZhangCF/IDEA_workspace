package com.zhangcf;

import com.blade.Blade;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        Blade blade = Blade.me();
        blade.listen(9000);
        blade.start(App.class, args);
    }
}

package com.rayyee;

import com.rayyee.socks.SocketServer;

public class Main
{

    public static void main( String[] args )
    {
        // write your code here
        try
        {
            new SocketServer( 8080 ).run();
        } catch ( Exception error )
        {

        }
    }
}

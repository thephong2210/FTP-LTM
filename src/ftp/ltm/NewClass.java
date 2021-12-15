/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp.ltm;

import java.util.StringTokenizer;

/**
 *
 * @author theph
 */
public class NewClass {
    public static void main(String[] args) {
        String s = "pppppppppppppppppppppppppppppppppp\nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn\nqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        StringTokenizer st = new StringTokenizer(s);
        System.out.println(st.countTokens());
        System.out.println(st.nextElement());
    }
    
}

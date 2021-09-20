package br.com.pineapple.utils;

import java.util.Date;

public class Data {
	public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}

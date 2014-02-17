/*
 * Joey  Bloom
 * Assignment #3
 * Collects user input and displays
 * using JOptionPane
 * 
 */

import javax.swing.JOptionPane;

public class WhatWouldYouLikeMeToDo
{
    public static void main(String[] args)
    {
        String name = 
            JOptionPane.showInputDialog(
            "What is your name?");
        JOptionPane.showInputDialog(
            "What would you like me to do?");
        JOptionPane.showMessageDialog(null, 
            "I'm sorry, " + name + 
            ". I'm afraid I can't do that.");
        System.exit(0);
    }
}

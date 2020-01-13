package com.test.lettercombination.beans;


import java.util.ArrayList;
import java.util.List;


public class DigitLettersList {

    private Node first;
    private Node last;

    private int size = 0;

    private List<String> letterCombinationList;


    public List<String> getAllLetterCombinations() {
        this.letterCombinationList = new ArrayList<>();

        this.doGetCombination(this.first, "");
        return letterCombinationList;
    }

    /**
     * Core algorithm ：Depth-First-Search
     */
    private void doGetCombination(DigitLettersList.Node currentNode, String combinationLetter) {

        // If has next, compose current letter and keep search.
        if (currentNode.hasNext()) {
            if (currentNode.hasLetters()) {
                for (String letter : currentNode.letters) {
                    doGetCombination(currentNode.getNext(), combinationLetter + letter);
                }
            } else {
                doGetCombination(currentNode.getNext(), combinationLetter);
            }
        }
        // If has not next, compose all letters, add to letterCombinationList then return.
        else {
            if (currentNode.hasLetters()) {
                for (String letter : currentNode.letters) {
                    letterCombinationList.add(combinationLetter + letter);
                }
            } else {
                letterCombinationList.add(combinationLetter);
            }
        }
    }

    public boolean add(String[] letters) {
        linkLast(letters);
        return true;
    }


    void linkLast(String[] letters) {
        final DigitLettersList.Node l = last;
        final DigitLettersList.Node newNode = new DigitLettersList.Node(letters, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public int size() {
        return size;
    }


    private static class Node {
        String[] letters;
        Node next;

        Node(String[] letters, DigitLettersList.Node next) {
            this.letters = letters;
            this.next = next;
        }

        boolean hasLetters() {
            if (null != letters && letters.length > 0) {
                return true;
            }
            return false;
        }

        boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            return false;
        }

        Node getNext() {
            if (this.hasNext()) {
                return this.next;
            }
            // or throw exception
            return null;
        }
    }

}

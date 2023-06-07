package com.example.testapp;

public interface IMessageReceive {
    void onSMSReceive(String from, String content);
}

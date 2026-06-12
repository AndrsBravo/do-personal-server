package com.personal.shared.process.logs;

public record Log(String code, LogType type, String process, String rule, String should, String result) {

}

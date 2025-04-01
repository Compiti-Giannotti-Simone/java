package it.giannotti;

import lombok.Data;

@Data
public class ReturnMessage {
    private final int code;
    private final String message;
}


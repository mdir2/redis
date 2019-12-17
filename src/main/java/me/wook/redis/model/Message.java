package me.wook.redis.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Message implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String message;
}
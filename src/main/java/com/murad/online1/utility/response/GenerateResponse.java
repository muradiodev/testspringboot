package com.murad.online1.utility.response;

@FunctionalInterface
public interface GenerateResponse<Code, Message, Data, ResponseType> {

    ResponseType generate(Code code, Message message, Data data);

}

package ch.zuehlke.lambda.facilitator.domain;

import ch.zuehlke.lambda.facilitator.exception.BadRequestException;

public enum Reply {
    ACCEPTED, DECLINED, TENTATIVE, NO_REPLY;

    public static Reply fromString(String replyString) {
        try {
            return Reply.valueOf(replyString);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Could not map reply for input " + replyString);
        }
    }
}

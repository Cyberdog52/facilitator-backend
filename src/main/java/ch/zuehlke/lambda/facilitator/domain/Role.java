package ch.zuehlke.lambda.facilitator.domain;

import ch.zuehlke.lambda.facilitator.exception.BadRequestException;

public enum Role {
    HCU, TL, MEMBER;

    public static Role fromString(String roleName) {
        try {
            return Role.valueOf(roleName);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Could not map role for input " + roleName);
        }
    }
}

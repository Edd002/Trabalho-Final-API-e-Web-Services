package com.spring.crud.demo.aop;

import com.spring.crud.demo.model.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Before("@annotation(com.spring.crud.demo.annotation.LogObjectBefore)")
    public void logBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Event) {
                Event event = (Event) arg;
                log.info("******* Event before :: {}", event);
            } else if (arg instanceof Match) {
                Match match = (Match) arg;
                log.info("******* Match before :: {}", match);
            } else if (arg instanceof Player) {
                Player player = (Player) arg;
                log.info("******* Player before :: {}", player);
            } else if (arg instanceof Team) {
                Team team = (Team) arg;
                log.info("******* Team before :: {}", team);
            } else if (arg instanceof TeamMatch) {
                TeamMatch teamMatch = (TeamMatch) arg;
                log.info("******* TeamMatch before :: {}", teamMatch);
            } else if (arg instanceof TeamTournament) {
                TeamTournament teamTournament = (TeamTournament) arg;
                log.info("******* TeamTournament before :: {}", teamTournament);
            } else if (arg instanceof Tournament) {
                Tournament tournament = (Tournament) arg;
                log.info("******* Tournament before :: {}", tournament);
            } else if (arg instanceof Transfer) {
                Transfer transfer = (Transfer) arg;
                log.info("******* Transfer before :: {}", transfer);
            }
        }
    }

    @AfterReturning(value = "@annotation(com.spring.crud.demo.annotation.LogObjectAfter)", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        if (Objects.nonNull(result)) {
            if (result instanceof ResponseEntity) {
                ResponseEntity responseEntity = (ResponseEntity) result;

                if (responseEntity.getStatusCode().value() == 200)
                    log.info("******* Returning object :: {}", responseEntity.getBody());
                else
                    log.error("Something went wrong while logging...!");
            }
        }
    }
}
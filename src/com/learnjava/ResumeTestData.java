package com.learnjava;

import com.learnjava.model.*;

import java.time.LocalDate;
import java.util.Arrays;

import static com.learnjava.model.ContactType.*;
import static com.learnjava.model.SectionType.*;

public class ResumeTestData {

    private static Resume resume;

    private ResumeTestData() {
    }

    public static void fillResumeTestData() {
        resume = new Resume("Grigoriy Kislin");
        resume.addContact(MOBILE, "+7(921) 855-0482 ");
        resume.addContact(SKYPE, "skype:grigory.kislin");
        resume.addContact(MAIL, "gkislin@yandex.ru");
        resume.addSection(OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям "));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("Достижение1", "Достижение2", "Достижение3")));
        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(Arrays.asList(new Organization("Java Online Projects", "https://javaops.ru/", Arrays.asList(new Period(LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."))), new Organization("Wrike", "https://www.wrike.com/aa/", Arrays.asList(new Period(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."))))));
    }


    public static void printResumeTestData() {
        System.out.println("uuid and full name: " + resume.toString());
        System.out.println(MOBILE.getTitle() + " : " + resume.getContact(MOBILE));
        System.out.println(SKYPE.getTitle() + " : " + resume.getContact(SKYPE));
        System.out.println(MAIL.getTitle() + " : " + resume.getContact(MAIL));
        System.out.println(OBJECTIVE.getTitle() + " : " + resume.getSection(OBJECTIVE).toString());
        System.out.println(ACHIEVEMENT.getTitle() + " : " + resume.getSection(ACHIEVEMENT).toString());
        System.out.println(EXPERIENCE.getTitle() + " : " + resume.getSection(EXPERIENCE).toString());
    }

    public static void main(String[] args) {
        fillResumeTestData();
        printResumeTestData();
    }
}
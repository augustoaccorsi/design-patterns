package com.augustoaccorsi.chapter3.dependencyinjection;

import javax.inject.Inject;

public class Target {
    @Favourites
    @Inject
    Subject maths;
}

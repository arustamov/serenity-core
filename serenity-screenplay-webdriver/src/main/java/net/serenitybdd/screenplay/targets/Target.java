package net.serenitybdd.screenplay.targets;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;

import java.util.List;
import java.util.Optional;

public abstract class Target {

    protected final String targetElementName;
    protected final Optional<IFrame> iFrame;

    public Target(String targetElementName, Optional<IFrame> iFrame) {
        this.targetElementName = targetElementName;
        this.iFrame = iFrame;
    }

    @Override
    public String toString() {
        return targetElementName;
    }

    public static TargetBuilder the(String targetElementName) {
        return new TargetBuilder(targetElementName);
    }

    public abstract WebElementFacade resolveFor(Actor actor);

    public abstract List<WebElementFacade> resolveAllFor(Actor actor);

    public abstract Target called(String name);

    public abstract Target of(String... parameters);

    public abstract String getCssOrXPathSelector();

    public Optional<IFrame> getIFrame() {
        return iFrame;
    }

    public String getName() {
        return targetElementName;
    }

}

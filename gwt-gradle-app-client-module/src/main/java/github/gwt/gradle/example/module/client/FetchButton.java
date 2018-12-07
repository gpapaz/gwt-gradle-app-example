package github.gwt.gradle.example.module.client;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLButtonElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import static elemental2.dom.DomGlobal.document;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class FetchButton extends HTMLButtonElement {

    @JsOverlay
    public static FetchButton create(String caption, Runnable click) {
        HTMLButtonElement htmlButtonElement = (HTMLButtonElement) document.createElement("button");
        htmlButtonElement.textContent = caption;
        htmlButtonElement.onclick = p0 -> {
            click.run();
            return null;
        };

        return (FetchButton) htmlButtonElement;
    }
}

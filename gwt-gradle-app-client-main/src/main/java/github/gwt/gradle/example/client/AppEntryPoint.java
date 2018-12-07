package github.gwt.gradle.example.client;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;
import elemental2.dom.Response;
import github.gwt.gradle.example.module.client.FetchButton;
import github.gwt.gradle.example.shared.ServerHealth;

import static elemental2.core.Global.JSON;

public class AppEntryPoint implements EntryPoint {

    public interface ServerHealthMapper extends ObjectMapper<ServerHealth> {}

    @Override
    public void onModuleLoad() {
        DomGlobal
                .document
                .body
                .appendChild(FetchButton.create("Fetch Server Health", this::fetch));
    }

    private void fetch() {
        DomGlobal
                .fetch("health")
                .then(Response::json)
                .then(json -> {
                    DomGlobal.alert(deserializeServerHealth(JSON.stringify(json)).getStatus());

                    return null;
                });
    }

    private ServerHealth deserializeServerHealth(String json) {
        ServerHealthMapper mapper = GWT.create(ServerHealthMapper.class);
        return mapper.read(json);
    }
}

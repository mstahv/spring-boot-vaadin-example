package org.vaadin.springbootexample;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyVaadinUI extends UI {
    
    @Autowired
    private MyService service;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            Notification.show(service.sayHello());
        });
        
        layout.addComponent(button);

        setContent(layout);
    }
}

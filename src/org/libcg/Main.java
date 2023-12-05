package org.libcg;

import org.libcg.controllers.MenuController;
import org.libcg.core.App;
import org.libcg.database.DbInit;

public class Main {
    public static void main(String[] args) {
      DbInit.run();
      App.useProvider(new Provider());
      App.run(MenuController.class);
    }
}

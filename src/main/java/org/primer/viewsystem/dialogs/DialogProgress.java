/*
 *
 *  Copyright 2014 http://Bither.net
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * /
 */

package org.primer.viewsystem.dialogs;

import org.primer.PrimerUI;
import org.primer.viewsystem.base.Labels;
import org.primer.viewsystem.base.Panels;
import org.primer.viewsystem.themes.Themes;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by nn on 15/3/12.
 */
public class DialogProgress extends PrimerDialog {

    private JPanel contentPane;

    public DialogProgress() {
        contentPane = Panels.newPanel();
        setContentPane(contentPane);
        setModal(true);
        setUndecorated(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        initDialog();
        contentPane.setLayout(new MigLayout(
                Panels.migXYLayout(),
                "[]", // Column constraints
                "[]" // Row constraints

        ));
        JLabel labelRefrsh = Labels.newSpinner(Themes.currentTheme.fadedText(), PrimerUI.NORMAL_PLUS_ICON_SIZE);
        contentPane.add(labelRefrsh, "align center,span,wrap");

    }

}

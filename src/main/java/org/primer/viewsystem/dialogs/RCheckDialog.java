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

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.primer.Primer;
import org.primer.utils.LocaliserUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class RCheckDialog extends PrimerDialog {
    private JPanel contentPane;
    private JProgressBar pb;
    private JLabel labSuccess;
    private JLabel labMsg;


    public RCheckDialog() {

        labMsg.setText("");

        setContentPane(contentPane);
        setModal(true);
        setUndecorated(true);
        initDialog();
        Dimension dimension = Primer.getMainFrame().getSize();
        int w = (int) Math.min(dimension.getHeight() / 4, dimension.getHeight() / 4);
        setMinimumSize(new Dimension(w + 100, w));

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setWait();
    }

    private void onCancel() {
        dispose();
    }

    public void setWait() {
        pb.setVisible(true);
        labSuccess.setVisible(false);
        labMsg.setText(LocaliserUtils.getString("please_wait"));
    }

    public void setRecalculatingR() {
        pb.setVisible(true);
        labSuccess.setVisible(false);
        labMsg.setText(LocaliserUtils.getString("rcheck_recalculate"));
    }

    public void setRChecking() {
        pb.setVisible(true);
        labSuccess.setVisible(false);
        labMsg.setText(LocaliserUtils.getString("rchecking"));
    }

    public void setRCheckSuccess() {
        pb.setVisible(false);
        labSuccess.setVisible(true);
        labMsg.setText(LocaliserUtils.getString("rcheck_new_tx_success"));

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(1, 1, new Insets(10, 10, 10, 10), -1, -1));
        contentPane.setBackground(new Color(-328966));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setOpaque(false);
        contentPane.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setOpaque(false);
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        pb = new JProgressBar();
        pb.setDoubleBuffered(false);
        pb.setFocusCycleRoot(false);
        pb.setFocusTraversalPolicyProvider(false);
        pb.setIndeterminate(true);
        pb.setInheritsPopupMenu(false);
        panel2.add(pb, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labSuccess = new JLabel();
        labSuccess.setIcon(new ImageIcon(getClass().getResource("/images/accept.png")));
        labSuccess.setText("");
        panel2.add(labSuccess, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labMsg = new JLabel();
        labMsg.setText("Label");
        panel1.add(labMsg, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}

















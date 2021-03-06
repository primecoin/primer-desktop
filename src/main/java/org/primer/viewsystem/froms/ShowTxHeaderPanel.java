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

package org.primer.viewsystem.froms;

import org.primer.Primer;
import org.primer.fonts.MonospacedFont;
import org.primer.model.Ticker;
import org.primer.primerj.utils.UnitUtil;
import org.primer.primerj.utils.Utils;
import org.primer.utils.LocaliserUtils;
import org.primer.utils.MarketUtil;
import org.primer.utils.WalletUtils;
import org.primer.viewsystem.base.Buttons;
import org.primer.viewsystem.base.Panels;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowTxHeaderPanel {
    private JPanel panel;
    private JTextArea taAddress;
    private JButton btnAmt;

    private JButton btnSend;
    private JButton btnQRCode;
    private JButton btnCopy;
    private boolean isShowBtc = true;

    public ShowTxHeaderPanel() {
        initUi();

    }

    private void initUi() {
        panel = Panels.newPanel(new MigLayout(
                Panels.migXYLayout(),
                "10[][][][][][][]10", // Column constraints
                "10[]10" // Row constraints
        ));
        panel.setOpaque(true);
        final JLabel label1 = new JLabel();
        label1.setText(LocaliserUtils.getString("address_balance"));
        taAddress = new JTextArea();
        taAddress.setEditable(false);
        taAddress.setBorder(null);
        taAddress.setFont(MonospacedFont.fontWithSize(taAddress.getFont().getSize()));
        panel.add(taAddress);
        btnCopy = Buttons.newQRCodeButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnQRCode = Buttons.newQRCodeButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnSend = Buttons.newQRCodeButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAmt = Buttons.newButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAmt.setText("0.00");
        panel.add(btnCopy, "shrink");
        panel.add(btnQRCode, "shrink");
        panel.add(btnSend, "shrink");
        panel.add(label1);
        panel.add(btnAmt);
        updateUI();

    }

    public JPanel getPanel() {
        return panel;
    }

    private void showAmt() {
        if (Primer.getActionAddress() == null) {
            return;
        }
        if (isShowBtc) {
            btnAmt.setText(UnitUtil.formatValue(Primer.getActionAddress().getBalance(), UnitUtil.BitcoinUnit.BTC));

        } else {
            Ticker ticker = MarketUtil.getTickerOfDefaultMarket();
            double amt = ((double) Primer.getActionAddress().getBalance()) * ticker.getDefaultExchangePrice() / Math.pow(10, 8);
            btnAmt.setText(Utils.formatDoubleToMoneyString(amt));
        }

    }

    public void updateUI() {
        String address = "";
        showAmt();

        if (Primer.getActionAddress() != null) {
            address = Primer.getActionAddress().getAddress();
        }
        taAddress.setText(WalletUtils.formatHash(address, 4, 12));

        if (Primer.getActionAddress() != null && Primer.getActionAddress().getBalance() == 0) {
            btnSend.setEnabled(false);
        } else {
            btnSend.setEnabled(true);
        }


    }


}

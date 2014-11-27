package raysAlcher;

import org.powerbot.script.Condition;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;

public class Gui extends javax.swing.JFrame {

    public Gui() {
        initComponents();
        next();
    }
    private JLabel currentAction;
    private JTextField input;
    private JLabel casts;
    private JLabel castsHr;
    private JLabel jCurrentAction;
    private JLabel jCasts;
    private JLabel jCastsHr;
    private JLabel jMagicExpGained;
    private JLabel jMagicExpHr;
    private JLabel magicExpGained;
    private JLabel magicExpHr;
    private JLabel nameLabel;
    private JButton submitButton;
    private JLabel title;
    private JLabel jLevelsGained;
    private JLabel levelsGained;
    private JLabel runTime;
    private int itemID;
    

    private void initComponents() {

        input = new JTextField();
        nameLabel = new JLabel();
        title = new JLabel();
        submitButton = new JButton();
        jMagicExpHr = new JLabel();
        jCurrentAction = new JLabel();
        jCasts = new JLabel();
        jCastsHr = new JLabel();
        jMagicExpGained = new JLabel();
        currentAction = new JLabel();
        casts = new JLabel();
        castsHr = new JLabel();
        magicExpGained = new JLabel();
        magicExpHr = new JLabel();
        jLevelsGained = new JLabel();
        levelsGained = new JLabel();
        runTime = new JLabel();

        Font font = new Font("Times New Roman", 0, 14);
        
        input.setFont(font);

        nameLabel.setFont(font);
        nameLabel.setText("ID of item to alch:");

        title.setFont(new Font("Times New Roman", 1, 18));
        title.setText("Ray's Alcher");

        submitButton.setFont(font);
        submitButton.setText("Run");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jMagicExpHr.setFont(font);
        jMagicExpHr.setText("Magic Exp/hr");

        jCurrentAction.setFont(font);
        jCurrentAction.setText("Current Action:");

        jCasts.setFont(font); 
        jCasts.setText("Casts:");

        jCastsHr.setFont(font); // NOI18N
        jCastsHr.setText("Casts/hr:");

        jMagicExpGained.setFont(font); // NOI18N
        jMagicExpGained.setText("Magic Exp gained:");

        currentAction.setFont(font); // NOI18N
        currentAction.setText("");

        casts.setFont(font); // NOI18N
        casts.setText("");

        castsHr.setFont(font); // NOI18N
        castsHr.setText("");

        magicExpGained.setFont(font); // NOI18N
        magicExpGained.setText("");

        magicExpHr.setFont(font); // NOI18N
        magicExpHr.setText("");
        
        jLevelsGained.setFont(font); // NOI18N
        jLevelsGained.setText("Levels gained");

        levelsGained.setFont(font); // NOI18N
        levelsGained.setText("");
        
        runTime.setFont(font);
        runTime.setText("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jCurrentAction)
                                            .addComponent(jCasts)
                                            .addComponent(jCastsHr)
                                            .addComponent(jMagicExpGained)
                                            .addComponent(jMagicExpHr)
                                            .addComponent(jLevelsGained, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(currentAction, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(casts, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(castsHr, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                            .addComponent(magicExpGained, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(magicExpHr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(levelsGained, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(input, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(submitButton)))
                                .addGap(0, 91, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(runTime, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(runTime))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCurrentAction)
                    .addComponent(currentAction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCasts)
                    .addComponent(casts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCastsHr)
                    .addComponent(castsHr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jMagicExpGained)
                    .addComponent(magicExpGained))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jMagicExpHr)
                    .addComponent(magicExpHr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLevelsGained)
                    .addComponent(levelsGained))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	String str = input.getText();
    	itemID = Integer.parseInt(str);
    }   
    
    public int getItemID() 
    {
        while(itemID == 0) 
        {
            Condition.sleep(1000);
        }
        return itemID;
    }

    /**
     * @param args the command line arguments
     */
    public void next()
    {

    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }              
    
    public void setCasts(Integer c)
    {
    	casts.setText(c.toString());
    }
    
    public void setCastsHr(Integer cHr)
    {
    	castsHr.setText(cHr.toString());
    }
    
    public void setMagicExpGained(Integer exp)
    {
    	magicExpGained.setText(exp.toString());
    }
    
    public void setMagicExpHr(Integer expHr)
    {
    	magicExpHr.setText(expHr.toString());
    }
    
    public void setLevelsGained(Integer levels)
    {
    	levelsGained.setText(levels.toString());
    }
    
    public void setStatus(String status)
    {
    	currentAction.setText(status);
    }
    
    public void setRunTime(String runTime)
    {
    	this.runTime.setText(runTime);
    }
    
    public JButton getButton()
    {
    	return submitButton;
    }
}


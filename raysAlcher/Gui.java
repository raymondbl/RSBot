package raysAlcher;

import org.powerbot.script.Condition;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.util.concurrent.Callable;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

@SuppressWarnings("serial")
public class Gui extends javax.swing.JFrame {

    public Gui() {
        initComponents();
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
    private JLabel jProfit;
    private JLabel jProfitHr;
    private JLabel profit;
    private JLabel profitHr;
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
        jProfit = new JLabel();
        jProfitHr = new JLabel();
        profit = new JLabel();
        profitHr = new JLabel();

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
        jMagicExpHr.setText("Magic Exp/hr:");

        jCurrentAction.setFont(font);
        jCurrentAction.setText("Current Action:");

        jCasts.setFont(font); 
        jCasts.setText("Casts:");

        jCastsHr.setFont(font);
        jCastsHr.setText("Casts/hr:");
        jMagicExpGained.setFont(font);
        jMagicExpGained.setText("Magic Exp gained:");

        currentAction.setFont(font);
        currentAction.setText("");

        casts.setFont(font);
        casts.setText("");

        castsHr.setFont(font);  
        castsHr.setText("");

        magicExpGained.setFont(font);  
        magicExpGained.setText("");

        magicExpHr.setFont(font);  
        magicExpHr.setText("");
        
        jLevelsGained.setFont(font);  
        jLevelsGained.setText("Levels gained:");

        levelsGained.setFont(font);  
        levelsGained.setText("");
        
        runTime.setFont(font);
        runTime.setText("");
        
        jProfit.setFont(font);
        jProfit.setText("Profit:");
        
        profit.setFont(font);
        profit.setText("");
        
        jProfitHr.setFont(font);
        jProfitHr.setText("Profit/hr:");
        
        profitHr.setFont(font);
        profitHr.setText("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nameLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(runTime, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(input, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(submitButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jCurrentAction)
                            .addComponent(jCasts)
                            .addComponent(jCastsHr)
                            .addComponent(jMagicExpGained)
                            .addComponent(jMagicExpHr)
                            .addComponent(jLevelsGained, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProfit))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(profit)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(currentAction, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(casts, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(castsHr, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(magicExpGained, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(magicExpHr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(levelsGained, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(profitHr)))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProfitHr))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(title))
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
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCurrentAction)
                    .addComponent(currentAction))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCasts)
                    .addComponent(casts))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCastsHr)
                    .addComponent(castsHr))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jMagicExpGained)
                    .addComponent(magicExpGained))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jMagicExpHr)
                    .addComponent(magicExpHr))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLevelsGained)
                    .addComponent(levelsGained))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jProfit)
                    .addComponent(profit))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jProfitHr)
                    .addComponent(profitHr))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                     

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	String str = input.getText();
    	itemID = Integer.parseInt(str);
    }   
    
    public int getItemID() 
    {
    	Condition.wait(new Callable<Boolean>(){
    	    @Override
    	    public Boolean call() throws Exception {
    	        return itemID != 0;
    	    }
    	}, 1000, Integer.MAX_VALUE);
    	return itemID;
    }
    
    public void setCasts(int c)
    {
    	casts.setText(String.valueOf(c));
    }
    
    public void setCastsHr(int cHr)
    {
    	castsHr.setText(String.valueOf(cHr));
    }
    
    public void setMagicExpGained(int exp)
    {
    	magicExpGained.setText(String.valueOf(exp));
    }
    
    public void setMagicExpHr(int expHr)
    {
    	magicExpHr.setText(String.valueOf(expHr));
    }
    
    public void setLevelsGained(int levels)
    {
    	levelsGained.setText(String.valueOf(levels));
    }
    
    public void setStatus(String status)
    {
    	currentAction.setText(status);
    }
    
    public void setRunTime(String runTime)
    {
    	this.runTime.setText(runTime);
    }
    
    public void setProfit(int profit)
    {
    	this.profit.setText(String.valueOf(profit));
    }
    
    public void setProfitHr(int profitHr)
    {
    	this.profitHr.setText(String.valueOf(profitHr));
    }
    public JButton getButton()
    {
    	return submitButton;
    }
}


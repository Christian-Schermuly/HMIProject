/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Controller-Class Mensch ärgere dich nicht
*/
package hmiproject;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 *
 * @author Chris
 */

public class FXMLDocumentController implements Initializable {
    
    //Variablen für alle Spiele
    private int MenschAIPlayer = 1;
    
    public Dice dice = new Dice();
    public Mensch mensch = new Mensch();
    public String active = "Images/Mensch/active.png";
    public String inactive = "Images/Mensch/inactive.png";
    public String design = "Images/Mensch/Designs/Smily/" ;

    /*
    SoundFiles
    Quellen:
    dice = http://soundbible.com/182-Shake-And-Roll-Dice.html
    move = http://soundbible.com/2068-Woosh.html
    beat = http://soundbible.com/2069-Realistic-Punch.html
    click = http://soundbible.com/1705-Click2.html
    */
    Media soundDice = new Media(new File("src/hmiproject/Sounds/dice.wav").toURI().toString());
    MediaPlayer mpDice = new MediaPlayer(soundDice);
    
    Media soundClick = new Media(new File("src/hmiproject/Sounds/click.wav").toURI().toString());
    MediaPlayer mpClick = new MediaPlayer(soundClick);
    //Panes
    @FXML
    private Pane PaneMensch;
    @FXML
    private Pane PaneNewGame;
    //Menu_Elemente
    @FXML
    private RadioButton P1;
    @FXML
    private RadioButton P2;
    @FXML
    private RadioButton P3;
    @FXML
    private RadioButton P4;
    @FXML
    private RadioButton Des1;
    @FXML
    private RadioButton Des2;
    
    //Markierung Aktiver Spieler
    @FXML
    private ImageView redAc;
    @FXML
    private ImageView greenAc;
    @FXML
    private ImageView yellowAc;
    @FXML
    private ImageView blueAc;

    //Markierung letzter Wurf
    @FXML
    private ImageView ViewDiceMenschR;
    @FXML
    private ImageView ViewDiceMenschG;
    @FXML
    private ImageView ViewDiceMenschY;
    @FXML
    private ImageView ViewDiceMenschB;
  
    
    //Elemente Mensch ärgere dich nicht
    //Image View (Außer Feld)
    @FXML
    private ImageView ViewDiceMensch;


    
    /*
    Wechsel zwischen Panes
    */
    
    @FXML
    private void selectPaneNewGame(){
       
        PaneMensch.setVisible(false);
        PaneNewGame.setVisible(true);
        mpClick.stop();
        mpClick.play();

    }
    
    private void selectPaneMensch(){
        PaneMensch.setVisible(true);
        PaneNewGame.setVisible(false);
        mpClick.stop();
        mpClick.play();
    }
    

 //Handler für nicht Spielbezogene Elemente
    
    @FXML
    private void handleBtnStartMensch(ActionEvent event){
        mensch.clearField();
        mpClick.stop();
        mpClick.play();
        
        menschSetStones();
        activePlayerMarker();
        selectPaneMensch();
    }

    
        @FXML
    private void handleBtnExit(ActionEvent event) {
       Platform.exit();
    }

    @FXML
    private void handleBtnMNG(ActionEvent event){
        selectPaneNewGame(); 
        mpClick.stop();
        mpClick.play();
    }
    
    @FXML
//FigurenDesign (Testweise)
    private void handleDes1(ActionEvent event){
        Des1.setSelected(true);
        Des2.setSelected(false);
        design = "Images/Mensch/Designs/Smily/" ;
    
}
    @FXML
    private void handleDes2(ActionEvent event){
        Des1.setSelected(false);
        Des2.setSelected(true);
        design = "Images/Mensch/Designs/Figuren/" ;
    
}
    //Spieleranzahl
        @FXML
    private void handleP1(){
        P1.setSelected(true);
        P2.setSelected(false);
        P3.setSelected(false);
        P4.setSelected(false);
        MenschAIPlayer = 1;
    
    }
    @FXML
    private void handleP2(ActionEvent event){
        P1.setSelected(false);
        P2.setSelected(true);
        P3.setSelected(false);
        P4.setSelected(false);
        MenschAIPlayer = 2;
    
    }
    @FXML
    private void handleP3(ActionEvent event){
        P1.setSelected(false);
        P2.setSelected(false);
        P3.setSelected(true);
        P4.setSelected(false);
        MenschAIPlayer = 3;
    
    }
    @FXML
    private void handleP4(ActionEvent event){
        P1.setSelected(false);
        P2.setSelected(false);
        P3.setSelected(false);
        P4.setSelected(true);
        MenschAIPlayer = 4;
    
    }
    
    //Handler Spiele Bezogene Elemente (Kein Spielfeld)
        @FXML
    private void handleDiceClick(MouseEvent event){
        rollDice();
    }
    
            @FXML
    private void handleNextRound(ActionEvent event){
        System.out.println("Next Round");
        mpClick.stop();
        mpClick.play();
        mensch.nextPlayer();
        activePlayerMarker();
        menschSetStones();
        if(mensch.getPlayer() > MenschAIPlayer){
            AIMove();
        }
    }
    

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    //Markierung für aktiven Spieler
    private void activePlayerMarker(){
        
        int p = mensch.getPlayer();
        if(p == 1){
            redAc.setImage(new Image(FXMLDocumentController.class.getResource(active).toExternalForm()));  
        }else{
            redAc.setImage(new Image(FXMLDocumentController.class.getResource(inactive).toExternalForm()));
        }
        if(p == 2){
            greenAc.setImage(new Image(FXMLDocumentController.class.getResource(active).toExternalForm()));
        }else{
            greenAc.setImage(new Image(FXMLDocumentController.class.getResource(inactive).toExternalForm()));
        }
        if(p == 3){
            yellowAc.setImage(new Image(FXMLDocumentController.class.getResource(active).toExternalForm()));
        }else{
            yellowAc.setImage(new Image(FXMLDocumentController.class.getResource(inactive).toExternalForm()));
        }
        if(p == 4){
            blueAc.setImage(new Image(FXMLDocumentController.class.getResource(active).toExternalForm()));
        }else{
            blueAc.setImage(new Image(FXMLDocumentController.class.getResource(inactive).toExternalForm()));
        }
        
    }
    
    private void rollDice(){
        menschSetStones();
        mpDice.stop();
        mpDice.play();
        int roll = mensch.throwDice();
        if(roll == 0){
            System.out.println("Es wurde bereits gewürfelt! Bitte Ziehen!");
        }else{
        System.out.println(roll);
        ViewDiceMensch.setImage(new Image(FXMLDocumentController.class.getResource("Images/Dice/" + roll + ".jpeg").toExternalForm()));
        int p = mensch.getPlayer();
        if(p == 1){
            ViewDiceMenschR.setImage(new Image(FXMLDocumentController.class.getResource("Images/Dice/" + roll + ".jpeg").toExternalForm()));
        }
        if(p == 2){
            ViewDiceMenschG.setImage(new Image(FXMLDocumentController.class.getResource("Images/Dice/" + roll + ".jpeg").toExternalForm()));
        }
        if(p == 3){
            ViewDiceMenschY.setImage(new Image(FXMLDocumentController.class.getResource("Images/Dice/" + roll + ".jpeg").toExternalForm()));
        }
        if(p == 4){
            ViewDiceMenschB.setImage(new Image(FXMLDocumentController.class.getResource("Images/Dice/" + roll + ".jpeg").toExternalForm()));
        }
        }
    }
    //AI Methoden
    private void AIMove(){
        if(mensch.getPlayer() == 2){
            System.out.println("AI2");
            AI2();

            mensch.nextPlayer();
            activePlayerMarker();
        }
            if(mensch.getPlayer() == 3){
            System.out.println("AI3");
            AI3();
            mensch.nextPlayer();
            activePlayerMarker();
        }
            if(mensch.getPlayer() == 4){
            System.out.println("AI4");
            AI4();
 
            mensch.nextPlayer();
            activePlayerMarker();
        }
        
        
    }
    private void AI2(){
        rollDice();
        handleGreenLaunch();
        rollDice();
        int z = mensch.AIRound();
        if(z != 100){
            System.out.println("ZugStart " +z);
            menschZug(z);
                        System.out.println("+  " +mensch.getDice());
                        if(mensch.homezonemode){
                            handleGreenHome();
                        }
            menschZug(mensch.getDesti());
        }
        

        
        
    }
    private void AI3(){
        rollDice();
        handleYellowLaunch();
        rollDice();
        int z = mensch.AIRound();
        if(z != 100){
            System.out.println("ZugStart " +z);
            menschZug(z);
                        System.out.println("+  " +mensch.getDice());
                        if(mensch.homezonemode){
                            handleYellowHome();
                        }
            menschZug(mensch.getDesti());
        }
  
        
        
    }
    private void AI4(){
        rollDice();
        handleBlueLaunch();
        rollDice();
        int z = mensch.AIRound();
        if(z != 100){
            System.out.println("ZugStart " +z);
            menschZug(z);
                        System.out.println("+  " +mensch.getDice());
                        if(mensch.homezonemode){
                            handleBlueHome();
                        }
            menschZug(mensch.getDesti());
        }

       
        
    }
    
    //Spielfeld Mensch ärgere dich nicht
    //Startflächen
    
    private void menschSetStones(){
        menschSetHomes();
        menschSetField(mensch.getField());
        menschSetStart();
        
    }
    private void menschSetHomes(){
        int[][] f = mensch.getHome();
        RedHome1.setImage(new Image(FXMLDocumentController.class.getResource(design + f[0][0] +".jpeg").toExternalForm()));
        RedHome2.setImage(new Image(FXMLDocumentController.class.getResource(design + f[0][1] +".jpeg").toExternalForm()));
        RedHome3.setImage(new Image(FXMLDocumentController.class.getResource(design + f[0][2] +".jpeg").toExternalForm()));
        RedHome4.setImage(new Image(FXMLDocumentController.class.getResource(design + f[0][3] +".jpeg").toExternalForm()));
        
        GreenHome1.setImage(new Image(FXMLDocumentController.class.getResource(design + f[1][0] +".jpeg").toExternalForm()));
        GreenHome2.setImage(new Image(FXMLDocumentController.class.getResource(design + f[1][1] +".jpeg").toExternalForm()));
        GreenHome3.setImage(new Image(FXMLDocumentController.class.getResource(design + f[1][2] +".jpeg").toExternalForm()));
        GreenHome4.setImage(new Image(FXMLDocumentController.class.getResource(design + f[1][3] +".jpeg").toExternalForm()));
        
        YellowHome1.setImage(new Image(FXMLDocumentController.class.getResource(design + f[2][0] +".jpeg").toExternalForm()));
        YellowHome2.setImage(new Image(FXMLDocumentController.class.getResource(design + f[2][1] +".jpeg").toExternalForm()));
        YellowHome3.setImage(new Image(FXMLDocumentController.class.getResource(design + f[2][2] +".jpeg").toExternalForm()));
        YellowHome4.setImage(new Image(FXMLDocumentController.class.getResource(design + f[2][0] +".jpeg").toExternalForm()));
        
        BlueHome1.setImage(new Image(FXMLDocumentController.class.getResource(design + f[3][0] +".jpeg").toExternalForm()));
        BlueHome2.setImage(new Image(FXMLDocumentController.class.getResource(design + f[3][1] +".jpeg").toExternalForm()));
        BlueHome3.setImage(new Image(FXMLDocumentController.class.getResource(design + f[3][2] +".jpeg").toExternalForm()));
        BlueHome4.setImage(new Image(FXMLDocumentController.class.getResource(design + f[3][3] +".jpeg").toExternalForm()));
        
        
    }
    private void menschSetField(int[] f){
        MF00.setImage(new Image(FXMLDocumentController.class.getResource(design + f[0] +".jpeg").toExternalForm()));
        MF01.setImage(new Image(FXMLDocumentController.class.getResource(design + f[1] +".jpeg").toExternalForm()));
        MF02.setImage(new Image(FXMLDocumentController.class.getResource(design + f[2] +".jpeg").toExternalForm()));       
        MF03.setImage(new Image(FXMLDocumentController.class.getResource(design + f[3] +".jpeg").toExternalForm()));   
        MF04.setImage(new Image(FXMLDocumentController.class.getResource(design + f[4] +".jpeg").toExternalForm()));     
        MF05.setImage(new Image(FXMLDocumentController.class.getResource(design + f[5] +".jpeg").toExternalForm()));
        MF06.setImage(new Image(FXMLDocumentController.class.getResource(design + f[6] +".jpeg").toExternalForm()));   
        MF07.setImage(new Image(FXMLDocumentController.class.getResource(design + f[7] +".jpeg").toExternalForm()));
        MF08.setImage(new Image(FXMLDocumentController.class.getResource(design + f[8] +".jpeg").toExternalForm()));
        MF09.setImage(new Image(FXMLDocumentController.class.getResource(design + f[9] +".jpeg").toExternalForm()));
        MF10.setImage(new Image(FXMLDocumentController.class.getResource(design + f[10] +".jpeg").toExternalForm()));
        MF11.setImage(new Image(FXMLDocumentController.class.getResource(design + f[11] +".jpeg").toExternalForm()));
        MF12.setImage(new Image(FXMLDocumentController.class.getResource(design + f[12] +".jpeg").toExternalForm()));
        MF13.setImage(new Image(FXMLDocumentController.class.getResource(design + f[13] +".jpeg").toExternalForm()));
        MF14.setImage(new Image(FXMLDocumentController.class.getResource(design + f[14] +".jpeg").toExternalForm()));
        MF15.setImage(new Image(FXMLDocumentController.class.getResource(design + f[15] +".jpeg").toExternalForm()));
        MF16.setImage(new Image(FXMLDocumentController.class.getResource(design + f[16] +".jpeg").toExternalForm()));
        MF17.setImage(new Image(FXMLDocumentController.class.getResource(design + f[17] +".jpeg").toExternalForm()));
        MF18.setImage(new Image(FXMLDocumentController.class.getResource(design + f[18] +".jpeg").toExternalForm()));
        MF19.setImage(new Image(FXMLDocumentController.class.getResource(design + f[19] +".jpeg").toExternalForm()));
        MF20.setImage(new Image(FXMLDocumentController.class.getResource(design + f[20] +".jpeg").toExternalForm()));
        MF21.setImage(new Image(FXMLDocumentController.class.getResource(design + f[21] +".jpeg").toExternalForm()));
        MF22.setImage(new Image(FXMLDocumentController.class.getResource(design + f[22] +".jpeg").toExternalForm()));
        MF23.setImage(new Image(FXMLDocumentController.class.getResource(design + f[23] +".jpeg").toExternalForm()));
        MF24.setImage(new Image(FXMLDocumentController.class.getResource(design + f[24] +".jpeg").toExternalForm()));
        MF25.setImage(new Image(FXMLDocumentController.class.getResource(design + f[25] +".jpeg").toExternalForm()));
        MF26.setImage(new Image(FXMLDocumentController.class.getResource(design + f[26] +".jpeg").toExternalForm()));
        MF27.setImage(new Image(FXMLDocumentController.class.getResource(design + f[27] +".jpeg").toExternalForm()));
        MF28.setImage(new Image(FXMLDocumentController.class.getResource(design + f[28] +".jpeg").toExternalForm()));
        MF29.setImage(new Image(FXMLDocumentController.class.getResource(design + f[29] +".jpeg").toExternalForm()));
        MF30.setImage(new Image(FXMLDocumentController.class.getResource(design + f[30] +".jpeg").toExternalForm())); 
        MF31.setImage(new Image(FXMLDocumentController.class.getResource(design + f[31] +".jpeg").toExternalForm())); 
        MF32.setImage(new Image(FXMLDocumentController.class.getResource(design + f[32] +".jpeg").toExternalForm())); 
        MF33.setImage(new Image(FXMLDocumentController.class.getResource(design + f[33] +".jpeg").toExternalForm())); 
        MF34.setImage(new Image(FXMLDocumentController.class.getResource(design + f[34] +".jpeg").toExternalForm())); 
        MF35.setImage(new Image(FXMLDocumentController.class.getResource(design + f[35] +".jpeg").toExternalForm())); 
        MF36.setImage(new Image(FXMLDocumentController.class.getResource(design + f[36] +".jpeg").toExternalForm())); 
        MF37.setImage(new Image(FXMLDocumentController.class.getResource(design + f[37] +".jpeg").toExternalForm())); 
        MF38.setImage(new Image(FXMLDocumentController.class.getResource(design + f[38] +".jpeg").toExternalForm())); 
        MF39.setImage(new Image(FXMLDocumentController.class.getResource(design + f[39] +".jpeg").toExternalForm()));  
    }
    private void menschSetStart(){
        mSetStartR();
        mSetStartG();
        mSetStartY();
        mSetStartB();
        
    }
    private void mSetStartR(){
        int h[] = mensch.getStartR();
        RedStart1.setImage(new Image(FXMLDocumentController.class.getResource(design + h[0] +".jpeg").toExternalForm()));
        RedStart2.setImage(new Image(FXMLDocumentController.class.getResource(design + h[1] +".jpeg").toExternalForm()));
        RedStart3.setImage(new Image(FXMLDocumentController.class.getResource(design + h[2] +".jpeg").toExternalForm()));
        RedStart4.setImage(new Image(FXMLDocumentController.class.getResource(design + h[3] +".jpeg").toExternalForm()));
    }
    private void mSetStartG(){
        int h[] = mensch.getStartG();
        GreenStart1.setImage(new Image(FXMLDocumentController.class.getResource(design + h[0] +".jpeg").toExternalForm()));
        GreenStart2.setImage(new Image(FXMLDocumentController.class.getResource(design + h[1] +".jpeg").toExternalForm()));
        GreenStart3.setImage(new Image(FXMLDocumentController.class.getResource(design + h[2] +".jpeg").toExternalForm()));
        GreenStart4.setImage(new Image(FXMLDocumentController.class.getResource(design + h[3] +".jpeg").toExternalForm()));
    }
    private void mSetStartY(){
        int h[] = mensch.getStartY();
        YellowStart1.setImage(new Image(FXMLDocumentController.class.getResource(design + h[0] +".jpeg").toExternalForm()));
        YellowStart2.setImage(new Image(FXMLDocumentController.class.getResource(design + h[1] +".jpeg").toExternalForm()));
        YellowStart3.setImage(new Image(FXMLDocumentController.class.getResource(design + h[2] +".jpeg").toExternalForm()));
        YellowStart4.setImage(new Image(FXMLDocumentController.class.getResource(design + h[3] +".jpeg").toExternalForm()));
    }
    private void mSetStartB(){
        int h[] = mensch.getStartB();
        BlueStart1.setImage(new Image(FXMLDocumentController.class.getResource(design + h[0] +".jpeg").toExternalForm()));
        BlueStart2.setImage(new Image(FXMLDocumentController.class.getResource(design + h[1] +".jpeg").toExternalForm()));
        BlueStart3.setImage(new Image(FXMLDocumentController.class.getResource(design + h[2] +".jpeg").toExternalForm()));
        BlueStart4.setImage(new Image(FXMLDocumentController.class.getResource(design + h[3] +".jpeg").toExternalForm()));
    }

    //Figuren-Start
    @FXML
private void handleRedLaunch(){
    if(mensch.canLaunch()){
        mensch.launchRed();
        menschSetStones();
        
        
    }else{
        System.out.println("Nööö");
    }
    
}
    @FXML
private void handleGreenLaunch(){
    if(mensch.canLaunch()){
        System.out.println("YUHU");
        mensch.launchGreen();
        menschSetStones();
        
        
    }else{
        System.out.println("Nööö");
    }
    
}
    @FXML
private void handleYellowLaunch(){
    if(mensch.canLaunch()){
        System.out.println("YUHU");
        mensch.launchYellow();
        menschSetStones();
        
        
    }else{
        System.out.println("Nööö");
    }
    
}
    @FXML
private void handleBlueLaunch(){
    if(mensch.canLaunch()){
        System.out.println("YUHU");
        mensch.launchBlue();
        menschSetStones();
        
    }else{
        System.out.println("Nööö");
    }
    
}


private void menschZug(int pos){
    System.out.println("Zug?");
    if(mensch.getMoveMode() && mensch.desti == pos){
        System.out.println("start pos = " + pos);
        
        mensch.move(pos);
        menschSetStones();
        mensch.nextPlayer();
    }else{
    if(mensch.hatFigur(pos)){
       menschSetField(mensch.showMoveRange(pos));
       
         }else{
            System.out.println("Keine Figur");
         }
    }

}


private void MoveRedHome(){
    mensch.enterHomeRed();
    menschSetStones();
            
}

@FXML
private void handleRedHome(){
    MoveRedHome();
}
@FXML
private void handleGreenHome(){
    mensch.enterHomeGreen();
    menschSetStones();
    
}
@FXML
private void handleYellowHome(){
    mensch.enterHomeYellow();
    menschSetStones();
    
}
@FXML
private void handleBlueHome(){
    mensch.enterHomeBlue();
    menschSetStones();
    
}



@FXML
private void handlebtnAbbrechen(ActionEvent event){
    selectPaneMensch();
}
/*
Spielfeld Handler. Bestimmt Variable für die "menschZug(int i)"-Methode

*/
@FXML
private void handleMF00(){
    menschZug(0);
}
@FXML
private void handleMF01(){
    System.out.println("Sfdasd");
    menschZug(1);
}
@FXML
private void handleMF02(){
    menschZug(2);
}
@FXML
private void handleMF03(){
    menschZug(3);
}
@FXML
private void handleMF04(){
    menschZug(4);
}
@FXML
private void handleMF05(){
    menschZug(5);
}
@FXML
private void handleMF06(){
    menschZug(6);
}
@FXML
private void handleMF07(){
    menschZug(7);
}
@FXML
private void handleMF08(){
    menschZug(8);
}
@FXML
private void handleMF09(){
    menschZug(9);
}
@FXML
private void handleMF10(){
    menschZug(10);
}
@FXML
private void handleMF11(){
    menschZug(11);
}
@FXML
private void handleMF12(){
    menschZug(12);
}
@FXML
private void handleMF13(){
    menschZug(13);
}
@FXML
private void handleMF14(){
    menschZug(14);
}

@FXML
private void handleMF15(){
    menschZug(15);
}
@FXML
private void handleMF16(){
    menschZug(16);
}
@FXML
private void handleMF17(){
    menschZug(17);
}
@FXML
private void handleMF18(){
    menschZug(18);
}
@FXML
private void handleMF19(){
    menschZug(19);
}
@FXML
private void handleMF20(){
    menschZug(20);
}
@FXML
private void handleMF21(){
    menschZug(21);
}
@FXML
private void handleMF22(){
    menschZug(22);
}
@FXML
private void handleMF23(){
    menschZug(23);
}
@FXML
private void handleMF24(){
    menschZug(24);
}
@FXML
private void handleMF25(){
    menschZug(25);
}
@FXML
private void handleMF26(){
    menschZug(26);
}
@FXML
private void handleMF27(){
    menschZug(27);
}
@FXML
private void handleMF28(){
    menschZug(28);
}
@FXML
private void handleMF29(){
    menschZug(29);
}    
@FXML
private void handleMF30(){
    menschZug(30);
}
@FXML
private void handleMF31(){
    menschZug(31);
}
@FXML
private void handleMF32(){
    menschZug(32);
}
@FXML
private void handleMF33(){
    menschZug(33);
}
@FXML
private void handleMF34(){
    menschZug(34);
}
@FXML
private void handleMF35(){
    menschZug(35);
}
@FXML
private void handleMF36(){
    menschZug(36);
}
@FXML
private void handleMF37(){
    menschZug(37);
}
@FXML
private void handleMF38(){
    menschZug(38);
}
@FXML
private void handleMF39(){
    menschZug(39);
}
/*
ID´s zum Ansprechen aller Elemente auf dem Spielfeld

*/

    @FXML
    private ImageView RedStart1;
    @FXML
    private ImageView RedStart2;
    @FXML
    private ImageView RedStart3;
    @FXML
    private ImageView RedStart4;
    
    @FXML
    private ImageView GreenStart1;
    @FXML
    private ImageView GreenStart2;
    @FXML
    private ImageView GreenStart3;
    @FXML
    private ImageView GreenStart4;
    
    @FXML
    private ImageView YellowStart1;
    @FXML
    private ImageView YellowStart2;
    @FXML
    private ImageView YellowStart3;
    @FXML
    private ImageView YellowStart4;
    
    @FXML
    private ImageView BlueStart1;
    @FXML
    private ImageView BlueStart2;
    @FXML
    private ImageView BlueStart3;
    @FXML
    private ImageView BlueStart4;
    
    @FXML
    private ImageView RedHome1;
    @FXML
    private ImageView RedHome2;
    @FXML
    private ImageView RedHome3;
    @FXML
    private ImageView RedHome4;
    
    @FXML
    private ImageView GreenHome1;
    @FXML
    private ImageView GreenHome2;
    @FXML
    private ImageView GreenHome3;
    @FXML
    private ImageView GreenHome4;
    
    @FXML
    private ImageView YellowHome1;
    @FXML
    private ImageView YellowHome2;
    @FXML
    private ImageView YellowHome3;
    @FXML
    private ImageView YellowHome4;
    
    @FXML
    private ImageView BlueHome1;
    @FXML
    private ImageView BlueHome2;
    @FXML
    private ImageView BlueHome3;
    @FXML
    private ImageView BlueHome4;
    
    
    //Spielfeld
    @FXML
    private ImageView MF00;
    @FXML
    private ImageView MF01;
    @FXML
    private ImageView MF02;
    @FXML
    private ImageView MF03;
    @FXML
    private ImageView MF04;
    @FXML
    private ImageView MF05;
    @FXML
    private ImageView MF06;
    @FXML
    private ImageView MF07;
    @FXML
    private ImageView MF08;
    @FXML
    private ImageView MF09;
    @FXML
    private ImageView MF10;
    @FXML
    private ImageView MF11;
    @FXML
    private ImageView MF12;
    @FXML
    private ImageView MF13;
    @FXML
    private ImageView MF14;
    @FXML
    private ImageView MF15;
    @FXML
    private ImageView MF16;
    @FXML
    private ImageView MF17;
    @FXML
    private ImageView MF18;
    @FXML
    private ImageView MF19;
    @FXML
    private ImageView MF20;
    @FXML
    private ImageView MF21;
    @FXML
    private ImageView MF22;
    @FXML
    private ImageView MF23;
    @FXML
    private ImageView MF24;
    @FXML
    private ImageView MF25;
    @FXML
    private ImageView MF26;
    @FXML
    private ImageView MF27;
    @FXML
    private ImageView MF28;
    @FXML
    private ImageView MF29;
    @FXML  
    private ImageView MF30;
    @FXML
    private ImageView MF31;
    @FXML
    private ImageView MF32;
    @FXML
    private ImageView MF33;
    @FXML
    private ImageView MF34;
    @FXML
    private ImageView MF35;
    @FXML
    private ImageView MF36;
    @FXML
    private ImageView MF37;
    @FXML
    private ImageView MF38;
    @FXML
    private ImageView MF39;
    
            

}



package 线性表;

import javafx.scene.chart.CategoryAxis;

import java.util.*;

/**
 * 顺序表 实现一个扑克牌小游戏
 * 一副扑克牌（不含大小王） 52张
 * 1、洗牌
 * 2、给五名玩家，各发四张牌 依次发牌
 * 3、判断最后 ♠A 在谁手里 谁获胜
 * 4、让每名玩家，依次抽取它的下家一张手牌。。。 然后再去找 ♠A
 * 5、周润发是赌神，所以他有变牌的能力： 他一旦手中没有黑桃A，就可以把第一张牌和有黑桃A的玩家互换
 * （交换牌之前，有机会变一次；交换牌以后，有机会变一次）
 */

class Player{
    public String name; // 玩家姓名
    public List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }
}

class Card {
    public String suit; // 花色
    public int rank; // 面值

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "{'" + suit + '\'' + ", " + rank + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Card)) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

}

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        players.add(new Player("周润发"));
        players.add(new Player("刘德华"));
        players.add(new Player("周星驰"));
        players.add(new Player("作者乔"));
        players.add(new Player("帅气的你"));


        // 初始化扑克牌
        initializeCards(cards);

        // 调用 Collections 下的 Shuffle(洗牌)方法
        // 进行洗牌
        Collections.shuffle(cards);
        System.out.println("洗牌完成后的牌");
        System.out.println(cards);

        // 发牌
        int n = 2; // 每名玩家发几张牌
        for(int i = 0; i < n ; i++) { // 一共发两轮牌
            for(Player player : players) { // 每名玩家依次抽牌
                Card card = cards.remove(0); // 从牌组中，抽一张牌出来
                player.cards.add(card); // 把这张牌放到当前玩家的手中
            }
        }
        System.out.println("现在牌组中剩余的牌： ");
        System.out.println(cards);

        System.out.println("交换牌之前： ");
        printPlayerHandCardList(players);

        Card toFoundCard = new Card("♠",1);
        Player 周润发 = players.get(0);
        winFaGe (周润发,toFoundCard,players);
        System.out.println("发哥第一次发功之后的牌： ");
        printPlayerHandCardList(players);

        // 交换牌（每名玩家抽取下家的一张随机手牌）
        Random random = new Random(); // 生成一个随机数
        for (int i = 0; i < players.size();i++) {
            Player currentPlayer = players.get(i); // 当前对象的牌
            Player nextPlayer = players.get(i != players.size() - 1 ? i+1 : 0);
            int toDrawIndex = random.nextInt(nextPlayer.cards.size()); // 获取下一个玩家的随机一张牌
            Card drawCard = nextPlayer.cards.remove(toDrawIndex); // 删除被取出的牌在原玩家中的信息
            currentPlayer.cards.add(drawCard); // 将取出牌的信息加到当前对象中
        }

        System.out.println("交换牌之后： ");
        printPlayerHandCardList(players);

        winFaGe (周润发,toFoundCard,players);
        System.out.println("发哥第二次成功之后： ");
        printPlayerHandCardList(players);

        // 找出 ♠A
        for (Player player : players) {
            for (Card card : player.cards) {
                // 比较每张牌和要找的那张牌是否是同一张牌
                if(card.equals(toFoundCard)) {
                    System.out.println(player.name+ " 获胜 ！！!");
                    return;
                }
            }
        }
        System.out.println("这把大家打平了！！!");
    }

    // 打印出每位玩家的 手牌
    public static void printPlayerHandCardList(List<Player> players) {
        for (Player player : players) {
            System.out.printf(" %s 的手牌是： %s%n", player.name, player.cards);
        }
    }

    // 周润发 换牌发功
    public static void winFaGe (Player 周润发,Card toFoundCard,List<Player> players) {
        if(!周润发.cards.contains(toFoundCard)) { // 若发哥手中没有 黑桃A
            Card card = 周润发.cards.get(0);
            周润发.cards.set(0,toFoundCard); // 得到发哥的第一张手牌
            for(int i = 0; i < players.size(); i++) {
                if(players.get(i).cards.contains(toFoundCard)) { // 找到拿黑桃A的那个玩家
                    /*players.get(i).cards.remove(toFoundCard); // 先把发哥手着的第一张牌移除
                    players.get(i).cards.add(card); // 将黑桃A放入发手中*/
                    int j = players.get(i).cards.indexOf(toFoundCard);
                    players.get(i).cards.set(j,card);
                }
            }
        }
    }

    // 初始化扑克牌
    private static void initializeCards(List<Card> cards) {
        for(String suit : new String[] {"♠","♥","♦","♣"}) {
            for(int rank = 1;rank <= 4;rank++) {
                Card card = new Card(suit,rank);
                // 把扑克牌放入牌组中
                cards.add(card);
            }
        }
    }


}

package 线性表;

import java.util.*;

/**
 * “捉鬼” 扑克小游戏：
 *  A- 5 ，20 张牌，去掉一张 A
 *  五个人依次抓牌，直到把所有的牌都抓光。抓拍阶段，一旦出现两张牌点数相同（凑成一对）就可以扔掉了
 *
 *  正式游戏：
 *  一个回合一个回合进行：
 *  每个人抽取下家的一张随机手牌：
 *  1、如果下家的手牌被抽完了，则下家退出游戏
 *  2、上家检查手中的牌有没有凑成一对，凑成了，还是把一对扔掉，如果扔掉一对后没手牌了，上家也退出
 *  直到只剩一个人，即为抓到“鬼”了
 */

class Player1{
    public String name; // 玩家姓名
    public List<Card1> cards = new ArrayList<>();

    public Player1(String name) {
        this.name = name;
    }
}

class Card1 {
    public String suit; // 花色
    public int rank; // 面值

    public Card1(String suit, int rank) {
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

    // 只比较点数相同：
    public boolean equalsRank(Card1 card) {
        return rank == card.rank;
    }

}

public class ArrayListDemo2 {
    public static void main(String[] args) {
        List<Player1> player1s = initializePlayerList();
        List<Card1> cards1 = initializeCardList(); // 初始化
        Collections.shuffle(cards1); // 洗牌

        drawCard(player1s,cards1);
        printHand(player1s);
    }

    private static void drawCard(List<Player1> player1s,List<Card1> card1s) {
        while (true) {
            for (Player1 player : player1s) {
                if(card1s.isEmpty()) {
                    // 唯一的出口
                    return;
                }

                 // 抽一张牌
                Card1 card1 = card1s.remove(0);
                // 先检查一下有没有对子
                boolean 是否需要把card加入手牌 = true;
                Iterator<Card1> it = player.cards.iterator();
                while (it.hasNext()) {
                    Card1 everyCard = it.next();
                    if (everyCard.equalsRank(card1)) {
                        it.remove();
                        是否需要把card加入手牌 = false;
                    }
                }
                if (是否需要把card加入手牌) {
                    player.cards.add(card1);
                }
            }
        }

    }

    // 打印出每位玩家的 手牌
    public static void printHand(List<Player1> players) {
        for (Player1 player : players) {
            System.out.printf(" %s 的手牌是： %s%n", player.name, player.cards);
        }
    }

    private static List<Player1> initializePlayerList() {
        List<Player1> player1s = new ArrayList<>();
        player1s.add(new Player1("周润发"));
        player1s.add(new Player1("刘德华"));
        player1s.add(new Player1("周星驰"));
        player1s.add(new Player1("作者乔"));
        player1s.add(new Player1("帅气的你"));
        return player1s;
    }

    private static List<Card1> initializeCardList() {
        List<Card1> cards1 = new ArrayList<>();
        for (String suit : new String[] {"♠","♥","♦","♣"}) {
            for(int rank = 1;rank <= 4;rank++) {
                Card1 card1 = new Card1(suit,rank);
                // 把扑克牌放入牌组中
                cards1.add(card1);
            }
        }
        // 删掉黑桃A
        return cards1;
    }
}


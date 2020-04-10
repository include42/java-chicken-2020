package view;

import domain.menu.Menu;
import domain.money.Money;
import domain.table.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_ORDERED_LINE = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottonLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottonLine(final List<Table> tables) {
        for (Table table : tables) {
            if(table.isOrdered()) {
                System.out.print(BOTTOM_ORDERED_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printFormat() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문하기");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printOrders(Table table) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        Map<Menu, Integer> menus = table.getMenus();
        for(Menu menu : menus.keySet()) {
            if(menus.get(menu) > 0) {
                System.out.println(menu.getName() + menus.get(menu) + menu.getPrice().multiply(menus.get(menu)).toString());
                // TODO: 2020/04/10 여기는 임시방편!! 고치기
            }
        }
        System.out.println();
        System.out.println("## "+table.getNumber() + "번 테이블의 결제를 진행합니다.");
    }

    public static void printPrice(Money price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(price.toString() + "원");
    }
}

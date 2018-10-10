package com.company;

class node{
    int Value;
    node Future = null;
    node Previous = null;

    public node(int x) {
        Value = x;
    }

    public void print() {
        if(this.Future != null) {
            System.out.println(this.Value +"->"+this.Future.Value);
        }
    }
}

class LinkedList {
    node Heads;
    node Tails;
    node C;
    int Total = 1;

    public LinkedList() {
        Total = 0;
    }

    public void PrintNums() {
        node curx = Heads;
        while (curx.Future != null) {
            System.out.print(curx.Value + " , ");
            curx = curx.Future;
        }
        System.out.println(curx.Value);
    }

    public void Mix() {
        System.out.println("Mixing: ");
        node C1, C2;
        int rand1, rand2;
        for (int i = 0; i < 50; i++) {
            C1 = Heads;
            C2 = Heads;
            rand1 = (int) (Math.random() * (Total));
            rand1++;
            rand2 = (int) (Math.random() * (Total));
            rand2++;
            for (int j = 0; i < rand1; i++) {
                C1 = C1.Future;
            }
            for (int k = 0; k < rand2; k++) {
                C2 = C2.Future;
            }
            Switch(C1, C2);
        }
        this.PrintNums();
        C = Heads;
    }

    public void riabx(node i, node x) {
        if (i.Previous != null && i.Future != null) {
            i.Previous.Future = i.Future;
            i.Future.Previous = i.Previous;
        }
        if (i.Future == null) {
            i.Previous.Future = null;
            Tails = i.Previous;
        }
        if (i.Previous == null) {
            i.Future.Previous = null;
            Heads = i.Future;
        }
        if (x.Previous != null) {
            x.Previous.Future = i;
            i.Previous = x.Previous;
            x.Previous = i;
            i.Future = x;
        }
        if (x.Previous == null) {
            x.Previous = i;
            i.Future = x;
            i.Previous = null;
            Heads = i;
        }
        System.out.println("Taking out: " + i.Value + " and then adding:  " + x.Value);
    }

    public void riaax(node i, node x) {
        if (i.Previous != null && i.Future != null) {
            i.Previous.Future = i.Future;
            i.Future.Previous = i.Previous;
        }
        if (i.Future == null) {
            i.Previous.Future = null;
            Tails = i.Previous;
        }
        if (i.Previous == null) {
            i.Future.Previous = null;
            Heads = i.Future;
        }
        if (x.Future != null) {
            x.Future.Previous = i;
            i.Future = x.Future;
            x.Future = i;
            i.Previous = x;
        }
        if (x.Future == null) {
            x.Future = i;
            i.Previous = x;
            i.Future = null;
            Tails = i;
        }
        System.out.println("Taking out: " + i.Value + " and then adding: " + x.Value);
    }

    public void add(int x) {
        node n = new node(x);
        if (Heads == null) {
            Heads = n;
            Tails = n;
            return;
        }
        C = Heads;

        while (C.Future != null) {
            C = C.Future;
        }
        n.Previous = C;
        C.Future = n;
        Tails = n;
        Total++;
    }

    public void Switch(node x, node i) {
        int Hold = x.Value;
        x.Value = i.Value;
        i.Value = Hold;
    }

    public void partition(node start, node finish) {
        if (start.Future == null) {
            return;
        }
        if (start == finish || (start.Future == finish && start.Value <= finish.Value)) {
            return;
        }
        if (start.Future == finish && start.Value > finish.Value) {
            Switch(start, finish);
            return;
        }
        Boolean started = false;
        node NumHead = start;
        node part = start;
        node nextstart = null;
        node leq = null;
        C = start.Future;
        while (C.Future != null && C.Future != finish) {
            if (C.Value == part.Value) {
                System.out.println(C.Value + " = " + part.Value);
                node Hold;
                Hold = C.Future;
                riabx(C, part);
                if (!started) {
                    nextstart = C;
                }
                C = Hold;
            } else if (C.Value < part.Value) {
                System.out.println(C.Value + " < " + part.Value);
                node temp;
                temp = C.Future;
                if (leq != null) {
                    riabx(C, leq);
                }
                riabx(C, Heads);
                started = true;
                nextstart = C;
                C = temp;
            } else {
                System.out.println(C.Value + " > " + part.Value);
                C = C.Future;
            }
        }

        if (C.Future != null) {
            C = C.Future;
        }
        if (C.Value == part.Value) {
            System.out.println(C.Value + " = " + part.Value);
            riabx(C, part);
            leq = C;
        } else if (C.Value < part.Value) {
            System.out.println(C.Value + " < " + part.Value);
            riabx(C, Heads);
        }
        if (nextstart == null) {
            nextstart = start;
        }
        this.PrintNums();
        if (leq != null) {
            this.partition(nextstart, leq);
        } else if (nextstart != null) {
            this.partition(nextstart, part);
        }
        if (part.Future != null) {
            this.partition(part.Future, finish);
        }
    }

    public void quicksort() {
        this.Mix();
        if (Heads == null || Heads.Future == null) {
            return;
        }
        this.partition(Heads, Tails);

    }
}
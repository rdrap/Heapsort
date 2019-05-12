package heapsort;

import java.util.*;

public class Heapsort {

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        for (int i = 0; i < 100; i++)
            heap.insert((int) (Math.random() * 101));
        System.out.println("Sorting...");
        heap.sort();
        heap.printHeap();
    }
}

/*
SAMPLE OUTPUT:
Sorting...
0
3
2
3
4
4
6
8
9
10
10
10
10
11
11
13
14
16
16
17
17
17
18
20
21
22
22
23
24
25
26
27
30
30
31
31
34
37
38
38
38
39
40
41
41
42
42
42
44
45
46
47
48
49
49
50
54
54
55
56
56
56
56
58
65
65
67
67
68
68
69
69
70
70
70
71
71
72
72
74
74
75
76
77
77
79
81
84
86
88
89
90
90
91
91
92
94
96
98
100
 */

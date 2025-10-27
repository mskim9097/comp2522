//interface Animal
//{
//    void sound();
//}
//// 1: static nested class
//class Zoo1
//{
//    static class AnimalStatic
//    {
//        void sound()
//        {
//            System.out.println("Zoo1: roar from static nested class");
//        }
//    }
//
//    static void demo()
//    {
//        new AnimalStatic().sound();
//    }
//}
//
//// 2. inner (non-static) class
//class Zoo2
//{
//    class AnimalInner
//    {
//        void sound()
//        {
//            System.out.println("Zoo2: roar (inner)");
//        }
//    }
//
//    void demo()
//    {
//        new AnimalInner().sound();
//    }
//}
//
//// 3. local inner class: defined inside a method
//class Zoo3
//{
//    void demo()
//    {
//        class AnimalLocal
//        {
//            void sound()
//            {
//                System.out.println("Zoo3: local inner");
//            }
//        }
//
//        new AnimalLocal.sound();
//    }
//
//}

package raccoon:

    import scala.scalanative.unsafe.*, Nat.*

    object Terminal:

        import libos.VGA_Color, VGA_Color.*

        inline val VGA_Width: 80 = 80
        inline val VGA_Height: 25 = 25

        var row, column = 0
        var color = VGA_Color.colorPoint(VGA_LIGHT_GREY, VGA_BLACK)
        // var buf = Ptr[CArray[CUnsignedShort, Digit6[_7, _5, _3, _6, _6, _4]]]

    end Terminal
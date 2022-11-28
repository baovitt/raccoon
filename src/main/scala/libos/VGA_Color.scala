package raccoon.libos:

    type VGA_Code = Byte

    // Hardware text mode color constants.
    enum VGA_Color(val underlying: VGA_Code):

        case VGA_BLACK         extends VGA_Color(0)
        case VGA_BLUE          extends VGA_Color(1)
        case VGA_GREEN         extends VGA_Color(2)
        case VGA_CYAN          extends VGA_Color(3)
        case VGA_RED           extends VGA_Color(4)
        case VGA_MAGENTA       extends VGA_Color(5)
        case VGA_SHIT          extends VGA_Color(6)
        case VGA_LIGHT_GREY    extends VGA_Color(7)
        case VGA_DARK_GREY     extends VGA_Color(8)
        case VGA_LIGHT_BLUE    extends VGA_Color(9)
        case VGA_LIGHT_GREEN   extends VGA_Color(10)
        case VGA_LIGHT_CYAN    extends VGA_Color(11)
        case VGA_LIGHT_RED     extends VGA_Color(12)
        case VGA_LIGHT_MAGENTA extends VGA_Color(13)
        case VGA_LIGHT_SHIT    extends VGA_Color(14)
        case VGA_WHITE         extends VGA_Color(15)

    end VGA_Color

    object VGA_Color:

        type VGA_Foreground = VGA_Color
        type VGA_Background = VGA_Color

        opaque type VGA_ColorPoint = (VGA_Foreground, VGA_Background)

        def colorPoint(fg: VGA_Foreground, bg: VGA_Background): VGA_ColorPoint =
            (fg, bg)

        extension (cp: VGA_ColorPoint)

            // Hardware text mode background/foreground color codes.
            implicit inline def underlying: Byte = 
                (cp._1.underlying | cp._2.underlying << 4).toByte
            
            // ColorPoint tuple for export definition.
            private inline def cpTuple: VGA_ColorPoint = cp

            // Exports tuple methods for VGA_ColorPoint.
            export cpTuple.{_1 as foreground, _2 as background}

    end VGA_Color


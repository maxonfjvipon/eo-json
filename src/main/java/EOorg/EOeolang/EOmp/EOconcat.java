/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2022 Eugene Darashkevich
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package EOorg.EOeolang.EOmp;
import org.eolang.*;

import java.util.Arrays;

@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOconcat extends PhDefault {

    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOconcat(final Phi sigma) {
        super(sigma);
        this.add("arr1", new AtFree());
        this.add("arr2", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            final Phi[] first = new Dataized(rho.attr("arr1").get()).take(Phi[].class);
            final Phi[] second = new Dataized(rho.attr("arr2").get()).take(Phi[].class);
            final Phi[] result = Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, result, first.length, second.length);
            return new Data.ToPhi(result);
        }));
    }

}
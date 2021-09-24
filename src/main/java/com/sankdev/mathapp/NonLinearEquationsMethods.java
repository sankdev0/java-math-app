package com.sankdev.mathapp;

public class NonLinearEquationsMethods {

  private void PolovDel() {
    NonLinearEquations nu = new NonLinearEquations();
    while (Math.abs(nu.getB() - nu.getA()) > nu.getEps()) {
      if (nu.f(nu.getA()) * nu.f(nu.Mid()) < 0) {
        nu.setB(nu.Mid());
      } else {
        nu.setA(nu.Mid());
      }
    }
  }

//    private void Hord_Click(object sender, EventArgs e)
//    {
//      NU nu = new NU();
//      double xNext = 0;
//      double temp;
//      do
//      {
//        temp = xNext;
//        xNext = nu.B - nu.f(nu.B) * (nu.A - nu.B) /
//            (nu.f(nu.A) - nu.f(nu.B));
//        nu.A = nu.B;
//        nu.B = temp;
//      }
//      while (Math.Abs(xNext - nu.B) > nu.Eps);
//      richTextBox1.Text = xNext.ToString();
//    }
//    private void Kasatel_Click(object sender, EventArgs e)
//    {
//      NU nu = new NU();
//      double x = nu.A;
//      do
//      {
//        nu.A = x;
//        x = nu.A - nu.f(x) / nu.f1(x);
//      }
//      while (Math.Abs(nu.A - x) > nu.Eps);
//      richTextBox1.Text = x.ToString();
//    }
//  }

}

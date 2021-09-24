package com.sankdev.mathapp;

class NonLinearEquations
{
  private double a = -5;
  private double b = 8;
  private double eps = 0.001;

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }

  public double getEps() {
    return eps;
  }

  public void setEps(double eps) {
    this.eps = eps;
  }

  public double f(double x)
  {
    return Math.pow(2, x) - 5 * x - 3;
  }
  public double Mid()
  {
    return (this.a + this.b) / 2;
  }
  public double f1(double x)
  {
    return Math.pow(2, x) * Math.log(2) - 5;
  }
}

(ns sicp.ch1-test
	(:require [clojure.test :refer :all]
		[sicp.ch1 :refer :all]))

(defn assert-equal [x y]
	(is (= x y)))

(deftest ch1-1-3-test
	(testing "biggest-sqr-sum is failed"
		(assert-equal (biggest-sqr-sum 2 2 3) 13)
		(assert-equal (biggest-sqr-sum 1 2 0) 5)
		(assert-equal (biggest-sqr-sum 2 0 1) 5)))

(deftest ch1-1-11-test
	(testing "f-rec is failed"
		(assert-equal (f-rec 2) 2)
		(assert-equal (f-rec 5) 11)
		(assert-equal (f-rec 3) 3)))

(deftest ch1-1-12-test
	(testing "pascal-triangle is failed"
		(assert-equal (pascal-triangle 8 3) 56)
		(assert-equal (pascal-triangle 10 5) 252)
		(assert-equal (pascal-triangle 7 5) 21)
		(assert-equal (pascal-triangle 6 2) 15)))

(deftest ch1-1-16-test
	(testing "fast-expt is failed"
		(assert-equal (fast-expt 2 2) 4)
		(assert-equal (fast-expt 36 2) 1296)))

(deftest ch1-1-17-test
	(testing "multiply is failed"
		(assert-equal (multiply 2 2) 4)
		(assert-equal (multiply 5 5) 25)
		(assert-equal (multiply 100 100) 10000)
		(assert-equal (multiply 9 9) 81)))

(deftest ch1-1-18-test
	(testing "multiply_rp(ex 1.18) is failed"
		(assert-equal (multiply_rp 2 2) 4)
		(assert-equal (multiply_rp 32 13) 416)
		(assert-equal (multiply_rp 19 17) 323)
		(assert-equal (multiply_rp 11 5) 55)))

(deftest ch1-1-7-test
	(testing "sqrt is failed"
		(assert-equal (sqrt 2) 1.4166666666666665)
		(assert-equal (sqrt 1000) 251.249000999001)
		(assert-equal (sqrt 14) 4.683333333333334)))

(deftest ch1-1-8-test
	(testing "cube-root is failed"
		(assert-equal (cube-root 9) 2.0801227065868515)
		(assert-equal (cube-root 100) 4.641603653712197)
		(assert-equal (cube-root 1) 1.0)
		(assert-equal (cube-root 39) 3.391230593997027)))

(deftest ch1-1-41-test
	(testing "doublefn(ex 1.41) is failed"
			 (assert-equal (((doublefn (doublefn doublefn)) inc) 5) 21)
			 (assert-equal ((doublefn inc) 1) 3)))


(deftest ch1-1-42-test
	(testing "compose(ex 1.42) is failed"
			 (assert-equal ((compose inc inc) 2) 4)))

(deftest ch1-1-43-test
	(testing "repeated(ex 1.43) is failed"
			 (assert-equal ((repeated (fn [x](* x x)) 2) 5) 625)))

(deftest ch1-1-43-test
	(testing "repeated(ex 1.43) is failed"
			 (assert-equal ((repeated (fn [x](* x x)) 2) 5) 625)))

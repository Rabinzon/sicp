(ns sicp.ch1)

;; ex 1.3
(defn sqr [x]
	(* x x))

(defn biggest [x, y]
	(> x y))

(defn sqr-sum [x , y]
	(+ (sqr x) (sqr y)))

(defn biggest-sqr-sum [x, y, z]
	(if (biggest x y)
		(if (biggest y z)
			(sqr-sum x y)
			(sqr-sum x z))
		(if (biggest x z)
			(sqr-sum x y)
			(sqr-sum y z))))
;; end 1.3

;; ex 1.11
(defn f-rec [n]
	(if (< n 3) n
		(+	(f-rec (- n 1))
			(f-rec (- n 2))
			(f-rec (- n 3)))))
;; end 1.11

;; ex 1.12
(defn	factorial [x]
	(if (= x 1) x
	(* (factorial (- x 1)) x)))

(defn pascal-triangle [x, y]
	(/ (factorial x)
		(* (factorial y) (factorial (- x y)))))
;; end ex 1.12

;; ex 1.16

(defn fast-expt-iter [x, degree, acc]
	(if (= degree 0) acc
		(if (even? degree)
			(fast-expt-iter x (- degree 2) (* acc (sqr x)))
			(fast-expt-iter x (dec degree) (* acc x)))))

(defn fast-expt [x, degree]
	(fast-expt-iter x degree 1))

;; end 1.16

;; 1.17
(defn multiply [x, y]
	(if (= y 0) 0
		(if (even? y)
			(multiply (+ x x) (/ y 2))
			(+ x (multiply x (- y 1))))))


(defn multiply-fast [x, y]
	(defn iter [acc, a, b]
		(if (= b 0) acc
			(iter (+ acc a) a (- b 1))))
	(iter 0 x y))
;; end 1.17

;; ex 1.7
(defn abs [x]
	(if (> x 0) x (* -1 x)))

(defn sqrt [x]
	(defn good-enough? [guess, x]
		(< (abs (- (sqr guess) x)) 0.001))

	(defn average [x, y]
		(/ (+ x y) 2))

	(defn improve [guess, x]
		(average guess (/ x guess)))

	(defn sqrt-iter [ch, guess, x]
		(if (< ch 0.00001) guess
			(if (good-enough? guess x) guess
				(sqrt-iter (- (improve guess x) guess) (improve guess x) x))))
	(sqrt-iter 1.0 1.0 x))
;; end 1.7

;; 1.8
(defn cube [x]
	(* x x x))

(defn	cube-root [x]
	(defn good-enough? [guess, x]
		(< (abs (- (cube guess) x)) 0.001))

	(defn average [x, y]
		(/ (+ x y) 2))

	(defn improve [guess, x]
		(average guess
				 (/ (+ (/ x (sqr guess)) (* 2 guess)) 3)))

	(defn cube-iter [guess, x]
		(if (good-enough? guess x) guess
			(cube-iter (improve guess x) x)))
	(cube-iter 1.0 x))
;; end 1.8

;; ex 1.41

(defn doublefn [f]
	(fn [x]
		(f (f x))))
;; end 1.41

;; ex 1.42

(defn compose [f, g]
    (fn [x] (f(g x))))
;; end 1.42

;; ex 1.43
(defn repeated [f, y]
    (defn iter [fx, x, z]
      (if (= x 0)
        (fx z)
		  (iter (compose fx f) (- x 2) z)))
    (fn [z] (iter f y z)))
;; end 1.43

(defn multiply_rp[x, y]
	(letfn [(divide [q] (/ q 2))
			(multiply [q] (* q 2))
			(floor [x] (int (Math/floor x)))
			(even [f, k]
				  (if (= f 1) k
					  (multiply_rp (divide f) (multiply k)))
			)
			(odd [f, k, sum]
				(let [first (floor (divide f))
					second (floor (multiply k))]
				(if (= f 1) (+ sum k)
				(if (not= (mod f 2) 0)
					(odd first second ( + sum k))
					(odd first second sum)))))]

		(if (or (even? x) (even? y))
			(even x y)(odd x y 0))	))
(defn -main [& args]
	(println (multiply_rp 32 23)))

